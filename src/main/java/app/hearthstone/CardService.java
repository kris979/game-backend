package app.hearthstone;

import app.hearthstone.data.CardRepository;
import app.hearthstone.data.CardXMLRepository;
import app.hearthstone.model.Card;
import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private CardXMLRepository cardsRepository;
    private CardRepository databaseRepository;

    @Autowired
    public CardService(CardXMLRepository cardsRepository, CardRepository databaseRepository) {
        this.cardsRepository = cardsRepository;
        this.databaseRepository = databaseRepository;
        saveMinions();
    }

    private void saveMinions() {
        List<Card> minions = cardsRepository.getMinions();
        List<CardEntity> converted = new ArrayList<>();
        for (Card minion : minions) {
            CardEntity card = convert(minion);
            converted.add(card);
        }
        converted.stream().forEach(card -> databaseRepository.save(card));
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
        return new CardEntity(name, rarity, health,attack,cardType,race,cost,cardClass);
    }

    public List<Card> getCards() {
        return cardsRepository.getHeros();
    }

    public List<Card> getMinions() {
        return cardsRepository.getMinions();
    }

    public List<Card> getDragons() {
        return cardsRepository.getDragons();
    }

    public List<Card> getHeroes() {
        return cardsRepository.getHeros();
    }

    public List<Card> getSpells() {
        return cardsRepository.getSpells();
    }

    public List<Card> getHeroPowers() {
        return cardsRepository.getHeroPowers();
    }

    public List<CardEntity> getByType(CardType type) {
        return databaseRepository.findByCardType(type);
    }
}
