package com.MolvenoLakeResort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping("/")
public class TableController {

    @RequestMapping(value="/tables", method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        return "tables";
    }

}
