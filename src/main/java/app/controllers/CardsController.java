package app.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@Api
public class CardsController {
    
	@RequestMapping(value = "/cards", method = RequestMethod.GET)
    public String index() {
        return "Cards";
    }
    
    
    //localhost:8080/swagger-ui.html
//    http://localhost:8080/v2/api-docs
//    http://localhost:8080/swagger-ui.html#/
}
