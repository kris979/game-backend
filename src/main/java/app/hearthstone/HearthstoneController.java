package app.hearthstone;

import app.hearthstone.model.Card;
import app.hearthstone.model.CardEntity;
import app.hearthstone.model.CardType;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/cards/{type}", method = RequestMethod.GET)
    public List<CardEntity> cards(@PathVariable("type") CardType type) {
        return cardService.getByType(type);
    }

    @RequestMapping(value = "/cards", method = RequestMethod.GET)
    public List<CardEntity> cards(@RequestParam(value = "health", required = true) Integer health,
                                  @RequestParam(value = "attack", required = false) Integer attack) {
        return cardService.getByHealthAndAttack(health, Optional.ofNullable(attack));
    }

    @RequestMapping(value = "/cards", method = RequestMethod.POST)
    public void createAll() {
        cardService.saveAll();
    }

    @RequestMapping(value = "/cards", method = RequestMethod.DELETE)
    public void deleteAll() {
        cardService.deleteAll();
    }

    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
