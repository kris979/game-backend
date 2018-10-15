package app.hearthstone.data;

import app.hearthstone.model.Card;

import java.util.ArrayList;
import java.util.List;

public interface CardFilter {

    List<Card> filter(List<Card> cardsToFilter);

    default List<Card> filterSets(List<Card> ...sets) {
        List<Card> merged = new ArrayList<>();
        for (List<Card> set : sets) {
            merged.addAll(filter(set));
        }
        return merged;
    }
}
