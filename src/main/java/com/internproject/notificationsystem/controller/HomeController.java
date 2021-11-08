package com.internproject.notificationsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String in() {
        String a = "abc" ;
        return a ;
    }
}
