package app.hearthstone.parser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import app.hearthstone.parsers.CardParser;
import app.model.Card;
import static java.util.stream.Collectors.toList;

public class CardParserTest {

	@Test
	public void testParse() throws JsonParseException, JsonMappingException, IOException {
		CardParser parser = new CardParser();
		parser.parse();
		
		List<Card> cards = parser.getCards();
		System.out.println("size: " + cards.size());

		for (Card card : cards.stream().filter(c -> c.getType() != null && c.getType().equals("MINION")).collect(toList())) {
			System.out.println(card.getName());
		}
	}

}
