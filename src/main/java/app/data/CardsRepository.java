package app.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.hearthstone.parsers.CardParser;
import app.model.Card;
import app.model.CardType;

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

}
