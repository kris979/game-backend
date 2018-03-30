package app.controllers;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Cell;
import app.model.Room;
import app.services.BoardServices;
import app.services.RoomServices;

@RestController
@RequestMapping("/api")
public class ApiController {

    private RoomServices roomServices;
    private BoardServices boardServices;

    @Autowired
    public ApiController(RoomServices roomServices, BoardServices boardServices){
        super();
        this.roomServices = roomServices;
        this.boardServices = boardServices;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return this.roomServices.getAllRooms();
    }
    
	@RequestMapping(value = "/cards", method = RequestMethod.GET)
    public String index() {
        return "Cards";
    }
    
	@RequestMapping(value = "/board/walls", method = RequestMethod.GET)
    public Queue<Cell> walls() {
		return boardServices.getWalls();
    }
	
    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
