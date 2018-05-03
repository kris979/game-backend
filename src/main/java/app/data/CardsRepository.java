package app.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import app.hearthstone.parsers.CardParser;
import app.model.Card;

@Repository
public class CardsRepository {
	
	private CardParser parser; 
	private List<Card> cards = new ArrayList<>();

	@Autowired
	public CardsRepository(CardParser parser) {
		super();
		this.parser = parser;
		cards = parser.getCards();
	}
	

}
