package com.example.auto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/catalog")
    public String homePage() {
        return "models";
    }
}
