package ru.kpfu.itis.skatingblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.security.PermitAll;

@Controller
public class MainPageController {

    @PermitAll
    @GetMapping("/")
    public String getMainPage(){
        return "main_page";
    }

}
