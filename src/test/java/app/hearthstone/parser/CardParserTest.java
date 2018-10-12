package app.hearthstone.parser;

import app.hearthstone.data.CardFileReader;
import app.hearthstone.model.Card;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CardParserTest {
	
	@Test
	public void testParse() throws JsonParseException, JsonMappingException, IOException {
		CardFileReader parser = new CardFileReader();
		List<Card> cards = parser.getCards();
		assertThat(cards, is(notNullValue()));
		assertThat(cards.size(), greaterThan(100));
	}

}
