package ru.kpfu.itis.skatingblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class AboutController {

    @PermitAll
    @GetMapping("/about")

    public String getAboutPage(){
        return "about";
    }

}
