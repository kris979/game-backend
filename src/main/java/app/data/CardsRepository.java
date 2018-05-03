package app.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import app.model.Card;

@Repository
public class CardsRepository {
	
	private List<Card> cards = new ArrayList<>();

}
