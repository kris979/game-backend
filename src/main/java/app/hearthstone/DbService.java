package app.hearthstone;

import app.hearthstone.data.DbCardRepository;
import app.hearthstone.model.Card;
import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardEntityBuilder;
import app.hearthstone.model.CardType;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    private DbCardRepository databaseRepository;

    @Autowired
    public DbService(DbCardRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    public List<CardEntity> getBy(Integer health, Integer attack, Integer cost, String rarity, Integer page, Integer size, String sortBy, Sort.Direction direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return databaseRepository.findBy(health, attack, cost, rarity, pageRequest).getContent();
    }

    public CardEntity getById(Long id) throws EntityNotFoundException {
        Optional<CardEntity> card = this.databaseRepository.findById(id);
        if (!card.isPresent()) {
            throw new EntityNotFoundException(String.format("Card with id=%d does not exist. Are you sure you have got correct id?", id));
        } else {
            return card.get();
        }
    }

    public void deleteAll() {
        databaseRepository.deleteAll();
    }

    @Transactional
    public void saveAll(List<Card> minions) {
        List<CardEntity> converted = new ArrayList<>();
        for (Card card : minions) {
            CardEntity entity = convert(card);
            converted.add(entity);
        }
        converted.stream().forEach(card -> databaseRepository.save(card));
    }

    private CardEntity convert(@NotNull Card minion) {
        String type = minion.getType();
        CardType cardType;
        if (type.equalsIgnoreCase("Hero Power")) {
            cardType = CardType.HERO_POWER;
        } else {
            cardType = CardType.valueOf(type.toUpperCase());
        }
        final String race = minion.getRace();
        final Integer cost = minion.getCost();
        final String cardClass = minion.getPlayerClass();
        final String name = minion.getName();
        final String rarity = minion.getRarity();
        final Integer health = minion.getHealth();
        final Integer attack = minion.getAttack();
        return new CardEntityBuilder().withName(name).withRarity(rarity).withHealth(health).withAttack(attack).withCardType(cardType).withRace(race).withCost(cost).withCardClass(cardClass).createCardEntity();
    }
}
