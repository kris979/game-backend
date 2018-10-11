package app.hearthstone;

import app.hearthstone.data.CardRepository;
import app.hearthstone.data.CardXMLRepository;
import app.hearthstone.model.Card;
import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private CardXMLRepository cardsRepository;
    private CardRepository databaseRepository;

    @Autowired
    public CardService(CardXMLRepository cardsRepository, CardRepository databaseRepository) {
        this.cardsRepository = cardsRepository;
        this.databaseRepository = databaseRepository;
    }

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
        List<CardEntity> target = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(direction, sortBy));
        databaseRepository.findAll(pageRequest).forEach(target::add);
        return target;
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
        return new CardEntity(name, rarity, health, attack, cardType, race, cost, cardClass);
    }
}
