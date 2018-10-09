package app.hearthstone.parsers;

import app.hearthstone.model.Card;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CardParser {

	@Value("${card.filename}")
	private	Resource resource = new ClassPathResource("hearthstone_cards.json");
	
	private ObjectMapper mapper = new ObjectMapper();
	private List<Card> cards = new ArrayList<>();

	@Autowired
	public CardParser() {
		super();
		try {
			cards = mapper.readValue(resource.getFile(), new TypeReference<List<Card>>(){});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Card> getCards() {
		return cards;
	}
}

