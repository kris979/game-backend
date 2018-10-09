package app.services;

import app.data.CardRepository;
import app.data.CardsRepositoryImpl;
import app.model.hearthstone.Card;
import app.model.hearthstone.CardEntity;
import app.model.hearthstone.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private CardsRepositoryImpl cardsRepository;
    private CardRepository databaseRepository;

    @Autowired
    public CardService(CardsRepositoryImpl cardsRepository, CardRepository databaseRepository) {
        this.cardsRepository = cardsRepository;
        this.databaseRepository = databaseRepository;
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
}
