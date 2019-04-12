package app.services;

import app.cache.CardCacheLoader;
import app.cache.CardRemovalListener;
import app.data.DbCardRepository;
import app.data.JsonFileCardRepository;
import app.model.Card;
import app.model.CardEntity;
import app.model.CardEntityBuilder;
import app.model.CardType;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final LoadingCache<Long, CardEntity> cache;
    private JsonFileCardRepository cardsRepository;
    private DbCardRepository databaseRepository;

    @Autowired
    public CardService(JsonFileCardRepository cardsRepository, DbCardRepository databaseRepository, CardCacheLoader loader, CardRemovalListener listener) {
        this.cardsRepository = cardsRepository;
        this.databaseRepository = databaseRepository;
        cache = CacheBuilder.newBuilder()
                .maximumSize(2000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(listener)
                .build(loader);
    }

    @Transactional
    public void saveAll() {
        List<Card> minions = cardsRepository.getAll();
        List<CardEntity> converted = minions.stream().map((card) -> convert(card)).collect(Collectors.toList());
        databaseRepository.saveAll(converted);
    }

    public void deleteAll() {
        databaseRepository.deleteAll();
    }

    public List<CardEntity> getByType(CardType type) {
        return databaseRepository.findByCardType(type);
    }

    public List<CardEntity> getByAttack(Integer attack) {
        return databaseRepository.findByAttack(attack);
    }

    public List<CardEntity> getByCost(Integer cost) {
        return databaseRepository.findByCost(cost);
    }

    public List<CardEntity> getByHealth(Integer health) {
        return databaseRepository.findByHealth(health);
    }

    public List<CardEntity> getBy(Integer health, Integer attack, Integer cost, String rarity, Integer page, Integer size, String sortBy, Sort.Direction direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return databaseRepository.findBy(health, attack, cost, rarity, pageRequest).getContent();
    }

    private CardEntity convert(@org.jetbrains.annotations.NotNull Card minion) {
        final CardType cardType = minion.getType();
        final String race = minion.getRace();
        final Integer cost = minion.getCost();
        final String cardClass = minion.getCardClass();
        final String name = minion.getName();
        final String rarity = minion.getRarity();
        final Integer health = minion.getHealth();
        final Integer attack = minion.getAttack();
        return new CardEntityBuilder().withName(name).withRarity(rarity).withHealth(health).withAttack(attack).withCardType(cardType).withRace(race).withCost(cost).withCardClass(cardClass).createCardEntity();
    }

    public CardEntity getById(Long id) throws ExecutionException {
        return cache.get(id);
    }
}
