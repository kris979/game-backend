package app.hearthstone.parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.model.Card;

public class CardParser {

	private ObjectMapper mapper = new ObjectMapper();
	private	Resource resource = new ClassPathResource("hearthstone_cards.json");
	private List<Card> cards = new ArrayList<>();
	
	
	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void parse() throws JsonParseException, JsonMappingException, IOException {
		cards = mapper.readValue(resource.getFile(), new TypeReference<List<Card>>(){});
	}
}

