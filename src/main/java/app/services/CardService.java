package app.services;

import app.data.CardRepository;
import app.data.CardsRepositoryImpl;
import app.model.hearthstone.Card;
import app.model.hearthstone.CardEntity;
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

    public void saveMinions() {
        List<Card> minions = cardsRepository.getMinions();
        List<CardEntity> converted = new ArrayList<>();
        for (Card minion : minions) {
            CardEntity card = new CardEntity(minion.getName(), minion.getRarity(), minion.getHealth(), minion.getAttack());
            converted.add(card);
        }
        converted.stream().forEach(card -> databaseRepository.save(card));
    }
}
