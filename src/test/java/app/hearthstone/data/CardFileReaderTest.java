package app.hearthstone.data;

import app.hearthstone.model.Card;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import org.apache.http.client.HttpClient;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CardFileReaderTest {

    @Autowired
    private CardFileReader reader;

    @Test
    public void readBasicCards() {
        List<Card> cards = reader.readBasicCards();
        assertFalse(cards.isEmpty());
        assertThat(cards.size(), is(greaterThan(100)));
    }

    @Test
    public void readClassicCards() {
        List<Card> cards = reader.readClassicCards();
        assertFalse(cards.isEmpty());
        assertThat(cards.size(), is(greaterThan(100)));
    }

    @Test
    public void readBoomsdayCards() {
        List<Card> cards = reader.readBoomsdayCards();
        assertFalse(cards.isEmpty());
        assertThat(cards.size(), is(greaterThan(100)));
    }
}