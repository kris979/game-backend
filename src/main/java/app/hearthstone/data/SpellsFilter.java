package app.hearthstone.data;

import app.hearthstone.model.Card;
import app.hearthstone.model.CardType;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SpellsFilter implements CardFilter {

    @Override
    public List<Card> filter(List<Card> cardsToFilter) {
        return cardsToFilter.stream().filter(c -> c.getType() != null && c.getType().equalsIgnoreCase(CardType.SPELL.toString())).collect(toList());
    }
}
