package app.hearthstone.data;

import app.hearthstone.model.Card;
import app.hearthstone.model.CardType;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class HerosFilter implements CardFilter {

    @Override
    public List<Card> filter(List<Card> cardsToFilter) {
        return cardsToFilter.stream().filter(c -> c.getType() != null && c.getType().equalsIgnoreCase(CardType.HERO.toString())).collect(toList());
    }
}
