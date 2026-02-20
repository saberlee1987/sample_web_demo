package com.saber.sample_web_demo.controllers;

import com.saber.sample_web_demo.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/home")
@RequiredArgsConstructor
public class HomeController {

    private final PersonService personService;
    @GetMapping(value = "/page")
    public String homePage(Model model){
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Orange");
        colors.add("White");
        colors.add("Black");
        colors.add("Pink");
        model.addAttribute("colors",colors);
        model.addAttribute("persons",personService.getAllPersons());
        return "home";
    }

    @GetMapping("/persons")
    public String getPersons(Model model) {
        model.addAttribute("persons",personService.getAllPersons());
        return "home";
    }
}
