package app.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.hearthstone.parsers.CardParser;
import app.model.Card;
import app.model.CardType;
import app.model.VisibleRace;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

@Repository
public class CardsRepository {
	
	private CardParser parser; 
	private List<Card> cards = new ArrayList<>();

	@Autowired
	public CardsRepository(CardParser parser) {
		super();
		this.parser = parser;
		cards = this.parser.getCards();
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
}
