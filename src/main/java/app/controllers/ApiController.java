package app.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Room;
import app.services.RoomServices;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private RoomServices roomServices;

    @Autowired
    public ApiController(RoomServices roomServices){
        super();
        this.roomServices = roomServices;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return this.roomServices.getAllRooms();
    }
    
	@RequestMapping(value = "/cards", method = RequestMethod.GET)
    public String index() {
        return "Cards";
    }
    
    
    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
