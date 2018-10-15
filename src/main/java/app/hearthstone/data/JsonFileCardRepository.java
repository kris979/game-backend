package app.hearthstone.data;

import app.hearthstone.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JsonFileCardRepository {

    private List<Card> basic = new ArrayList<>();
    private List<Card> classic = new ArrayList<>();
    private List<Card> boomsday = new ArrayList<>();
    private List<Card> minions = new ArrayList<>();
    private List<Card> spells = new ArrayList<>();
    private List<Card> heroes = new ArrayList<>();

    @Autowired
    public JsonFileCardRepository(CardFileReader reader) {
        super();
        basic = reader.readBasicCards();
        classic = reader.readClassicCards();
        boomsday = reader.readBoomsdayCards();
        minions = new MinionsFilter().filterSets(basic, classic, boomsday);
        spells = new SpellsFilter().filterSets(basic, classic, boomsday);
        heroes = new HerosFilter().filterSets(basic, classic, boomsday);
    }

    public List<Card> getMinions() {
        return minions;
    }

    public List<Card> getSpells() {
        return spells;
    }

    public List<Card> getHeroes() {
        return heroes;
    }

}
