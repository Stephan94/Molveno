package com.MolvenoLakeResort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

// Create a

@Controller
@RequestMapping("/")
public class RouteController {

    @RequestMapping(value="/tables", method = RequestMethod.GET)
    public String tables(Map<String, Object> model) {
        return "tables";
    }

    @RequestMapping(value="/guests", method = RequestMethod.GET)
    public String guests(Map<String, Object> model) {
        return "guests";
    }

    @RequestMapping(value="/ingredients", method = RequestMethod.GET)
    public String ingredients(Map<String, Object> model) {
        return "ingredients";
    }
    @RequestMapping(value="/menuItems", method = RequestMethod.GET)
    public String menuItems(Map<String, Object> model) {
        return "menuItems";
    }

}
