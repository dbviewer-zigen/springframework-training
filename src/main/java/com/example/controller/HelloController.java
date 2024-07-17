package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HelloController {

    @GetMapping("/")
    public String heelo(ModelMap model) {
        model.addAttribute("message", "Hello World");        
        // return "hello";
        return "redirect:/todos";
    }
}
