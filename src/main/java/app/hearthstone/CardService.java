package app.hearthstone;

import app.hearthstone.data.JsonFileCardRepository;
import app.hearthstone.model.Card;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Service
public class CardService {

    private JsonFileCardRepository cardRepository;

    @Autowired
    public CardService(JsonFileCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getMinions() {
        return cardRepository.getMinions();
    }

    public List<Card> getSpells() {
        return cardRepository.getSpells();
    }

    public List<Card> getHeroes() {
        return cardRepository.getHeroes();
    }


}
