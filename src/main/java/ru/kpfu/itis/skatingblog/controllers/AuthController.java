package ru.kpfu.itis.skatingblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @GetMapping("/signin")
    public String getLoginPage(){
        return "login";
    }
}
