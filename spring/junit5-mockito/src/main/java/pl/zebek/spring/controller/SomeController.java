package pl.zebek.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SomeController {

    @ResponseBody
    @GetMapping("/")
    public String hello() {
        return "Controller is here!";
    }

}
