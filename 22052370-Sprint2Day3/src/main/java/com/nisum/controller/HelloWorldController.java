package com.nisum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
    @RequestMapping("/hello")
    public ModelAndView handleHello(){
        String msg = "Hello Spring Application";

        return new ModelAndView("hello", "message", msg);
    }
}