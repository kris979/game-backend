package app.hearthstone;

import app.hearthstone.model.Card;
import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

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
                                  @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "20") Integer size,
                                  @RequestParam(value = "sortBy", required = false, defaultValue = "name") String sortBy,
                                  @RequestParam(value = "direction", required = false, defaultValue = "ASC") Sort.Direction direction) {
        if (health == null) {
            return cardService.getAll(page, size, sortBy, direction);
        } else {
            return cardService.getByHealthAndAttack(health, Optional.ofNullable(attack));
        }
    }

    @RequestMapping(value = "/cards/{id}", method = RequestMethod.GET)
    public CardEntity cardsById(@PathVariable("id") Long id) {
        return cardService.getById(id);
    }

    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}