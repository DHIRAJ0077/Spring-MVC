package springMVC3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/footwear")
public class Controller2 {

    @GetMapping(path = { "/getmapping", "/fetchMapping" })
    public String get(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("FootwearController - fetchMapping");
        return "admin";
    }

    @GetMapping(path = { "/getParam" })
    public String getParam(@RequestParam(name = "name", defaultValue = "Guest") String name) {
        System.out.println("FootwearController - params=name:" + name);
        return "index";
    }

    @ResponseBody
    @GetMapping(path = { "/getCustomer/{customerId}/details" })
    public String getPathVariable(@PathVariable String customerId) {
        System.out.println("FootwearController - params=customerId : " + customerId);
        return "FootwearController - params=customerId : " + customerId;
    }
}