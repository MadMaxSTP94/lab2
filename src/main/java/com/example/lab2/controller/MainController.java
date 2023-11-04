package com.example.lab2.controller;

import com.example.lab2.model.BloodCharacteristics;
import com.example.lab2.model.Person;
import com.example.lab2.model.PressureCharacteristics;
import com.example.lab2.service.PersonCorrelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    private PersonCorrelationService personCorrelationService;
    private Person comperson;
    @GetMapping("/")
    public String getInputForm(Model model) {
        model.addAttribute("person", Person.build());
        return "index";
    }
    @PostMapping("/")
    public String postInputForm(Person person, PressureCharacteristics pressureCharacteristics, BloodCharacteristics bloodCharacteristics) {
        person.setBloodCharacteristics(bloodCharacteristics);
        person.setPressureCharacteristics(pressureCharacteristics);
        comperson = person;
        return "redirect:/result";
    }
    @GetMapping("/result")
    public String getResult(Model model) {
        var res = personCorrelationService.comparePersons(comperson);
        model.addAttribute("res", res);
        return "person";
    }

}
