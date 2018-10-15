package app.hearthstone;

import app.hearthstone.data.JsonFileCardRepository;
import app.hearthstone.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private JsonFileCardRepository cardRepository;

    @Autowired
    public CardService(JsonFileCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getMinions() {
        return cardRepository.getMinions();
    }

    public List<Card> getSpells() {
        return cardRepository.getSpells();
    }

    public List<Card> getHeroes() {
        return cardRepository.getHeroes();
    }
}
