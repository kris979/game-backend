package app.hearthstone.parser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import app.hearthstone.parsers.CardParser;
import app.model.Card;

public class CardParserTest {

	@Test
	public void testParse() throws JsonParseException, JsonMappingException, IOException {
		CardParser parser = new CardParser();
		List<Card> cards = parser.getCards();
		assertThat(cards, is(notNullValue()));
		assertThat(cards.size(), greaterThan(100));
	}

}
