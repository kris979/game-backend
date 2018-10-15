package app.hearthstone.data;

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
public class CardFileReader {

    @Value("${set.basic.filename}")
    private String basicSetFileName;

    @Value("${set.classic.filename}")
    private String classicSetFileName;

    @Value("${set.boomsday.filename}")
    private String boomsdaySetFileName;

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public CardFileReader() {
        super();
    }

    public List<Card> readBasicCards() {
        return getCards(basicSetFileName);
    }

    public List<Card> readClassicCards() { return getCards(classicSetFileName); }

    public List<Card> readBoomsdayCards() {
        return getCards(boomsdaySetFileName);
    }

    private List<Card> getCards(String s) {
        Resource resource = new ClassPathResource(s);
        List<Card> cards = new ArrayList<>();
        try {
            cards = mapper.readValue(resource.getFile(), new TypeReference<List<Card>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cards;
    }
}

