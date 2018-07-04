/*
package com.MolvenoLakeResort.controller.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


*/
/*
This controller is responsible for returning the correct template name based on the
entered URL

You ONLY use it for Mustache ...
 *//*

@Controller
@RequestMapping(value = "/a")
public class HomeController {

    // when I type in: http://localhost:8080/
    // then it returns "index" which will then look
    // in src/main/resources/templates and return the content
    // of the file index.html
    // while rendering the header and footer in using the
    // mustache operator ( {{>header}} and {{>footer}}
    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {
        return "index";
    }

    @RequestMapping(value = "/postget", method = RequestMethod.GET)
    public String jqueryPostGet(Map<String, Object> model) {
        return "jquery-post-get";
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public String bootstrap(Map<String, Object> model) {
        return "bootstrap-progress";
    }

    @RequestMapping(value = "/bootstrap2", method = RequestMethod.GET)
    public String bootstrap2(Map<String, Object> model) {
        return "bootstrap2";
    }

    @RequestMapping(value = "/jquery-demo", method = RequestMethod.GET)
    public String jQueryDemo(Map<String, Object> model) {
        return "jquery-demo";
    }
}
*/
