package com.nisum.controller;

import com.nisum.di.TextEditor;
import com.nisum.di.TextEditorSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TextEditorController {

    @Autowired
    @Qualifier("textEditorConstructor")
    private TextEditor textEditorConstructor;

    @Autowired
    @Qualifier("textEditorSetter")
    private TextEditorSetter textEditorSetter;

    @RequestMapping("/constructor")
    public ModelAndView showConstructor() {
        String result = textEditorConstructor.spellCheck();
        return new ModelAndView("result", "message", result);
    }

    @RequestMapping("/setter")
    public ModelAndView showSetter() {
        String result = textEditorSetter.spellCheck();
        return new ModelAndView("result", "message", result);
    }
}