package app.controllers;

import app.data.CardsRepositoryImpl;
import app.model.hearthstone.Card;
import app.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hearthstone")
public class HearthstoneController {

    private CardService cardService;

    @Autowired
    public HearthstoneController(CardService cardService) {
        super();
        this.cardService = cardService;
    }

    @RequestMapping(value = "/heros", method = RequestMethod.GET)
    public List<Card> heros() {
        return cardService.getCards();
    }

    @RequestMapping(value = "/minions", method = RequestMethod.GET)
    public List<Card> minions() {
        return cardService.getMinions();
    }

    @RequestMapping(value = "/minions/dragons", method = RequestMethod.GET)
    public List<Card> dragons() {
        return cardService.getDragons();
    }

    @RequestMapping(value = "/spells", method = RequestMethod.GET)
    public List<Card> spells() {
        return cardService.getSpells();
    }

    @RequestMapping(value = "/heroPowers", method = RequestMethod.GET)
    public List<Card> heroPowers() {
        return cardService.getHeroPowers();
    }

    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
