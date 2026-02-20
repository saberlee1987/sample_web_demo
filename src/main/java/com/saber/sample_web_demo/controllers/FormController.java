package com.saber.sample_web_demo.controllers;

import com.saber.sample_web_demo.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/myform")
@Slf4j
public class FormController {

    @GetMapping
    public String showMyFormPage(Model model) {
        model.addAttribute("person",new PersonDto());
        log.info(" show my form page called .....");
        return "myform";
    }
    @PostMapping(value = "/process")
    public String processForm(PersonDto personDto, Model model) {
        log.info("process form person ===> {}",personDto);
        model.addAttribute("person",personDto);
        return "myform";
    }
}
