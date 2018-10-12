package app.hearthstone;

import app.hearthstone.data.CardRepository;
import app.hearthstone.data.CardFileRepository;
import app.hearthstone.model.Card;
import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardEntityBuilder;
import app.hearthstone.model.CardType;
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
public class CardService {

    private CardFileRepository cardsRepository;
    private CardRepository databaseRepository;

    @Autowired
    public CardService(CardFileRepository cardsRepository, CardRepository databaseRepository) {
        this.cardsRepository = cardsRepository;
        this.databaseRepository = databaseRepository;
    }

    @Transactional
    public void saveAll() {
        List<Card> minions = cardsRepository.getAll();
        List<CardEntity> converted = new ArrayList<>();
        for (Card card : minions) {
            CardEntity entity = convert(card);
            converted.add(entity);
        }
        converted.stream().forEach(card -> databaseRepository.save(card));
    }

    public List<CardEntity> getAll(Integer page, Integer size, String sortBy, Sort.Direction direction) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return databaseRepository.findAll(pageRequest).getContent();
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

    public List<CardEntity> getByHealthAndAttack(Integer health, Optional<Integer> attack) {
        return databaseRepository.findByHealthAndOptionalAttack(health, attack);
    }

    private CardEntity convert(Card minion) {
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

    public CardEntity getById(Long id) throws EntityNotFoundException {
        Optional<CardEntity> card = this.databaseRepository.findById(id);
        if (!card.isPresent()) {
            throw new EntityNotFoundException(String.format("Card with id=%d does not exist. Are you sure you have got correct id?", id));
        } else {
            return card.get();
        }
    }
}
