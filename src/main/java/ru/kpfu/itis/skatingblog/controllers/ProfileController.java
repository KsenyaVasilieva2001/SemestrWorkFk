package ru.kpfu.itis.skatingblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.skatingblog.dto.ArticleDto;
import ru.kpfu.itis.skatingblog.dto.EditProfileDto;
import ru.kpfu.itis.skatingblog.models.User;
import ru.kpfu.itis.skatingblog.security.details.UserDetailsImpl;
import ru.kpfu.itis.skatingblog.services.ArticleService;
import ru.kpfu.itis.skatingblog.services.UserService;

import javax.annotation.security.PermitAll;
import java.util.Optional;

@Controller
public class ProfileController {

    private final UserService userService;


    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/profile")
    public String getProfile(@AuthenticationPrincipal UserDetails userDetails, Model model){
        Optional<User> user = userService.findUserByEmail(userDetails.getUsername());
        if(user.isPresent()){
            User userGet = user.get();
            model.addAttribute("firstName", userGet.getFirstName());
            model.addAttribute("lastName", userGet.getLastName());
            model.addAttribute("email", userGet.getEmail());
        }
        return "profile";
    }


    @PostMapping("/profile/edit")
    public String updateProfile(@AuthenticationPrincipal UserDetails userDetails,
                                @ModelAttribute("user") EditProfileDto editProfileDto){
        String firstNameNew = editProfileDto.getFirstName();
        String lastNameNew = editProfileDto.getLastName();
        userService.updateUser(firstNameNew,lastNameNew,userDetails.getUsername());
        return "redirect:/profile";
    }


    @GetMapping("/profile/edit")
    public String getEditProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails,

                                 Model model) {
        Optional<User> user = userService.findUserByEmail(userDetails.getUsername());
        EditProfileDto editProfileDto = new EditProfileDto();
        model.addAttribute("user", editProfileDto);
        if (user.isPresent()) {
            User userGet = user.get();
            model.addAttribute("firstName", userGet.getFirstName());
            model.addAttribute("lastName", userGet.getLastName());
        }

        return "edit_profile";
    }




}
