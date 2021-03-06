package app.controllers;

import app.model.CardEntity;
import app.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/hearthstone")
public class HearthstoneController {

    private CardService cardService;

    @Autowired
    public HearthstoneController(CardService cardService) {
        super();
        this.cardService = cardService;
    }

    @RequestMapping(value = "/cards", method = RequestMethod.POST)
    public void createAll() {
        cardService.saveAll();
    }

    @RequestMapping(value = "/cards", method = RequestMethod.DELETE)
    public void deleteAll() {
        cardService.deleteAll();
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public List<CardEntity> cards(@RequestParam(value = "health", required = false) Integer health,
                                  @RequestParam(value = "attack", required = false) Integer attack,
                                  @RequestParam(value = "cost", required = false) Integer cost,
                                  @RequestParam(value = "rarity", required = false) String rarity,
                                  @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
                                  @RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
                                  @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
            return cardService.getBy(health, attack, cost, rarity,page, size, sortBy, direction);
    }

    @RequestMapping(value = "/cards/{id}", method = RequestMethod.GET)
    public CardEntity cardsById(@PathVariable("id") Long id) throws ExecutionException {
        return cardService.getById(id);
    }

    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
