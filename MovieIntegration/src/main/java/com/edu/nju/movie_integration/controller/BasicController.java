package com.edu.nju.movie_integration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.edu.nju.movie_integration.util.AutoReply;

@Controller
public class BasicController {
    @RequestMapping("/")
    public String index(){
        //return "chat.html";
        return "index.jsp";
    }

    @RequestMapping("/reply")
    @ResponseBody
    public String getNormalReply(String question){
        System.out.println("BasicController调用reply方法");
        AutoReply autoReply = new AutoReply();
        String replystr = autoReply.getReply(question);
        System.out.println("reply: " + replystr);
        return replystr;
    }
}
