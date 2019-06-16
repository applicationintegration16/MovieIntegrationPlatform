package com.edu.nju.movie_integration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BasicController {
    @RequestMapping("/")
    public String index(){
        return "chat.html";
        //return "index.jsp";
    }
}
