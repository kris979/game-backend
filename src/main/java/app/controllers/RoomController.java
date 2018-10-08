package app.controllers;

import app.services.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is serving static index.html page
 * 
 * @author kris9
 *
 */
@Controller
@RequestMapping("/rooms")
public class RoomController {
    private RoomServices roomServices;

    @Autowired
    public RoomController(RoomServices roomServices){
        super();
        this.roomServices = roomServices;
    }

    /**
     * @param model
     * @return
     */
    @GetMapping
    public String getAllRooms(Model model){
        model.addAttribute("rooms", this.roomServices.getAllRooms());
        return "rooms";
    }
}
