package app.hearthstone.data;

import app.hearthstone.model.Card;
import app.hearthstone.model.CardType;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class JsonFileCardRepository {

    private List<Card> cards = new ArrayList<>();

    @Autowired
    public JsonFileCardRepository(CardFileReader parser) {
        super();
        cards = parser.getCards();
    }

    public List<Card> getMinions() {
        return cards.stream().filter(c -> c.getType() != null && c.getType().equals(CardType.MINION)).collect(toList());
    }

    public List<Card> getSpells() {
        return cards.stream().filter(c -> c.getType() != null && c.getType().equals(CardType.SPELL)).collect(toList());
    }

    public List<Card> getWeapons() {
        return cards.stream().filter(c -> c.getType() != null && c.getType().equals(CardType.WEAPON)).collect(toList());
    }

    public List<Card> getHeros() {
        return cards.stream().filter(c -> c.getType() != null && c.getType().equals(CardType.HERO)).collect(toList());
    }

    public List<Card> getHeroPowers() {
        return cards.stream().filter(c -> c.getType() != null && c.getType().equals(CardType.HERO_POWER)).collect(toList());
    }

    public List<Card> getEnchantments() {
        return cards.stream().filter(c -> c.getType() != null && c.getType().equals(CardType.ENCHANTMENT)).collect(toList());
    }

    public List<Card> getDragons() {
        return cards.stream().filter(c -> c.getRace() != null && c.getRace().equals("DRAGON")).collect(toList());
    }

    public List<Card> getAll() {
        return cards;
    }
}
