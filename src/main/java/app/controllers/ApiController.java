package app.controllers;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Cell;
import app.services.BoardServices;

@RestController
@RequestMapping("/api")
public class ApiController {

    private BoardServices boardServices;

    @Autowired
    public ApiController(BoardServices boardServices){
        super();
        this.boardServices = boardServices;
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
	
	
    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
