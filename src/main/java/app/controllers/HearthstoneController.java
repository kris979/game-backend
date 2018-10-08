package app.controllers;

import app.data.CardsRepository;
import app.model.hearthstone.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hearthstone")
public class HearthstoneController {

    private CardsRepository cardRepository;

    @Autowired
    public HearthstoneController(CardsRepository cardRepository){
        super();
        this.cardRepository = cardRepository;
    }

	@RequestMapping(value = "/heros", method = RequestMethod.GET)
    public List<Card> heros() {
		return cardRepository.getHeros();
    }

	@RequestMapping(value = "/minions", method = RequestMethod.GET)
    public List<Card> minions() {
		return cardRepository.getMinions();
    }

	@RequestMapping(value = "/minions/dragons", method = RequestMethod.GET)
    public List<Card> dragons() {
		return cardRepository.getDragons();
    }

	@RequestMapping(value = "/spells", method = RequestMethod.GET)
    public List<Card> spells() {
		return cardRepository.getSpells();
    }

    @RequestMapping(value = "/heroPowers", method = RequestMethod.GET)
    public List<Card> heroPowers() {
        return cardRepository.getHeroPowers();
    }


    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
