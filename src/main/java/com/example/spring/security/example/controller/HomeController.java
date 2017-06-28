package com.example.spring.security.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pkpk1234 on 2017/6/29.
 */
@Controller
public class HomeController {
    @GetMapping("/")
    public ModelAndView home() {
        Map<String,String> msg = new HashMap<>();
        msg.put("title","Home Page");
        msg.put("content","Home Page Content");
        msg.put("adminInfo","Only Admin User can see this message");
        msg.put("guestInfo","Only Guest User can see this message");
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("msg",msg);
        return mv;
    }
}
