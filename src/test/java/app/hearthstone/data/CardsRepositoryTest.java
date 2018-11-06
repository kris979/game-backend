package app.hearthstone.data;

import app.hearthstone.model.Card;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CardsRepositoryTest {

    @Autowired
    private JsonFileCardRepository repository;

    @Test
    public void testMinions() {
        List<Card> minions = repository.getMinions();
        assertThat(minions, is(notNullValue()));
        assertThat(minions.size(), is(greaterThan(100)));
    }

    @Test
    public void testHeros() {
        List<Card> minions = repository.getHeroes();
        assertThat(minions, is(notNullValue()));
        assertThat(minions.size(), is(greaterThan(0)));
    }

    @Test
    public void testSpells() {
        List<Card> minions = repository.getSpells();
        assertThat(minions, is(notNullValue()));
        assertThat(minions.size(), is(greaterThan(0)));
    }

//    @Test
//    public void fetchFile() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(
//                new ByteArrayHttpMessageConverter());
//
//        final HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        final HttpClient httpClient = HttpClientBuilder.create()
//                .setRedirectStrategy(new LaxRedirectStrategy())
//                .build();
//        factory.setHttpClient(httpClient);
//        restTemplate.setRequestFactory(factory);
//
//        extract(restTemplate, repository.getMinions());
//    }

    private void extract(RestTemplate restTemplate, List<Card> cards) {

        System.out.println(cards.size() + " minions to process");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        for (Card card : cards) {
            String imgGold = card.getImgGold();
            String[] split = imgGold.split("/");
            final String s = split[split.length - 1];
            ResponseEntity<byte[]> response = restTemplate.exchange(card.getImgGold(),
                    HttpMethod.GET, entity, byte[].class, "1");
            try {
                final Path path = Paths.get("e:/cards/minions/" + card.getCardId() + ".png");
                Files.write(path, response.getBody());
            } catch (IOException | RestClientException e) {
                e.printStackTrace();
                continue;
            }


        }
    }
}
