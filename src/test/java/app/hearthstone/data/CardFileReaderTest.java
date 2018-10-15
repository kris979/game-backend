package app.hearthstone.data;

import app.hearthstone.model.Card;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

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