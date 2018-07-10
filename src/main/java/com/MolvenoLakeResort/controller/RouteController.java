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
        return "ingredients"; }

    @RequestMapping(value="/menuItems", method = RequestMethod.GET)
    public String menuItems(Map<String, Object> model) {
        return "menuItems";
    }

    @RequestMapping(value="/contact", method = RequestMethod.GET)
    public String contact(Map<String, Object> model) {
        return "contact";
    }

    @RequestMapping(value="/bookings", method = RequestMethod.GET)
    public String bookings(Map<String, Object> model) {
        return "bookings";
    }

    @RequestMapping(value="/employeeHomePage", method = RequestMethod.GET)
    public String employeeHomePage(Map<String, Object> model) {
        return "employeeHomePage";
    }

    @RequestMapping(value="/mainMenu", method = RequestMethod.GET)
    public String mainMenu(Map<String, Object> model) {
        return "mainMenu"; 
    }

    @RequestMapping(value="/addBooking", method = RequestMethod.GET)
    public String addBooking(Map<String, Object> model) {
        return "addBooking"; 
    }
  
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        return "index";
    }
}
