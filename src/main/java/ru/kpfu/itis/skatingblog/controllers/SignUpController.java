package ru.kpfu.itis.skatingblog.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kpfu.itis.skatingblog.dto.SignUpForm;
import ru.kpfu.itis.skatingblog.dto.UserDto;
import ru.kpfu.itis.skatingblog.exceptions.DuplicateEntryException;
import ru.kpfu.itis.skatingblog.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Objects;

@Controller
public class SignUpController {

    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String showRegistForm(Model model){
        SignUpForm signUpForm = new SignUpForm();
        model.addAttribute("signUpForm", signUpForm);
        return "registration";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("signUpForm") @Valid SignUpForm signUpForm,
                               HttpServletRequest request,
                               BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().anyMatch(error -> {
                System.out.println(Arrays.toString(error.getCodes()));
                if (Objects.requireNonNull(error.getCodes())[0].equals("signUpForm.ValidPasswords")) {
                    model.addAttribute("passwordsErrorMessage", error.getDefaultMessage());
                }
                return true;
            });
            model.addAttribute("signUpForm", signUpForm);
            return "signup";
        }
        /*
        if (bindingResult.hasErrors()) {
            map.put("signUpForm", signUpForm);
            return "registration";
        }

         */
        try{
            userService.registerUser(signUpForm);
            return "redirect:/";
        }


        catch (DuplicateEntryException e){
            model.addAttribute("errorMessage","Пользователь с таким email уже существует");
           // map.put("messageError", "Пользователь с таким email уже существует");
            return "registration";
        }
    }

}
