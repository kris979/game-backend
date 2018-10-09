package app.hearthstone;

import app.hearthstone.model.Card;
import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public List<CardEntity> cards(@RequestParam(value = "type", required = false) CardType type) {
        return cardService.getByType(type);
    }


    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
