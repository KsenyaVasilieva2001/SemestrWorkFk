package ru.kpfu.itis.skatingblog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.skatingblog.dto.CoachDto;
import ru.kpfu.itis.skatingblog.dto.SpecialityDto;
import ru.kpfu.itis.skatingblog.models.Coach;
import ru.kpfu.itis.skatingblog.services.ArticleService;
import ru.kpfu.itis.skatingblog.services.CoachService;

import java.util.List;
import java.util.Optional;

@Controller
public class CoachController{

    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/coach/{coachId}")
    public String coachPage(@PathVariable Long coachId, Model model) {
        Optional<CoachDto> optionalCoachDto = coachService.getCoachById(coachId);
        if (optionalCoachDto.isPresent()) {
            model.addAttribute("coach", optionalCoachDto.get());
            return "coach";
        }
        model.addAttribute("error", "Тренер не найден");
        return "error_page";
    }

    @GetMapping("/coaches")
    public String coachesPage(Model model) {
        model.addAttribute("coaches", coachService.getAllCoaches());
        return "coachblog";
    }

    @PostMapping("/coaches")
    public @ResponseBody
    List<Coach> getCoach(@RequestBody SpecialityDto specialityDto, Model model) {
        return coachService.findCoachesBySpeciality(specialityDto.getName());
    }

}
