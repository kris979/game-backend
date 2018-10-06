package app.controllers;
import java.util.List;
import java.util.Queue;

import app.model.Student;
import app.data.StudentRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.data.CardsRepository;
import app.model.Card;
import app.services.BoardServices;
import app.shortestPath.Cell;

@RestController
@RequestMapping("/api")
public class ApiController {

    private BoardServices boardServices;
    private CardsRepository cardRepository;

    @Autowired
    public ApiController(BoardServices boardServices, CardsRepository cardRepository){
        super();
        this.boardServices = boardServices;
        this.cardRepository = cardRepository;
    }

    @GetMapping("/test")
    public String test(){
        return "OK";
    }

    @GetMapping("/board/shortestPath")
    public List<Cell> findShortestPath(){
        return this.boardServices.findShortestPath();
    }

	@RequestMapping(value = "/board/walls", method = RequestMethod.GET)
    public Queue<Cell> walls() {
		return boardServices.getWalls();
    }

	@RequestMapping(value = "/board/start", method = RequestMethod.PUT)
    public void setStart(@RequestBody Cell start) {
		boardServices.setStart(start);
    }

	@RequestMapping(value = "/board/end", method = RequestMethod.PUT)
    public void setEnd(@RequestBody Cell end) {
		boardServices.setEnd(end);
    }

	@RequestMapping(value = "/hearthstone/heros", method = RequestMethod.GET)
    public List<Card> heros() {
		return cardRepository.getHeros();
    }

	@RequestMapping(value = "/hearthstone/minions", method = RequestMethod.GET)
    public List<Card> minions() {
		return cardRepository.getMinions();
    }

	@RequestMapping(value = "/hearthstone/minions/dragons", method = RequestMethod.GET)
    public List<Card> dragons() {
		return cardRepository.getDragons();
    }

	@RequestMapping(value = "/hearthstone/spells", method = RequestMethod.GET)
    public List<Card> spells() {
		return cardRepository.getSpells();
    }

    @RequestMapping(value = "/hearthstone/heroPowers", method = RequestMethod.GET)
    public List<Card> heroPowers() {
        return cardRepository.getHeroPowers();
    }


    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
