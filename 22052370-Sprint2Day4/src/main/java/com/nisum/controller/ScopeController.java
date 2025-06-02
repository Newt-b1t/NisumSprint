package com.nisum.controller;

import com.nisum.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScopeController {

    @Autowired
    SingletonBean singletonBean;

    @Autowired
    PrototypeBean prototypeBean;

    @Autowired
    RequestBean requestBean;

    @Autowired
    SessionBean sessionBean;

    @RequestMapping("/scope")
    public ModelAndView showScopes() {
        ModelAndView mv = new ModelAndView("scope");
        mv.addObject("singleton", singletonBean.getScope());
        mv.addObject("prototype", prototypeBean.getScope());
        mv.addObject("request", requestBean.getScope());
        mv.addObject("session", sessionBean.getScope());
        return mv;
    }
}
