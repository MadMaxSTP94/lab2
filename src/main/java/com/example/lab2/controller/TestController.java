package com.example.lab2.controller;

import com.example.lab2.model.HealthClass;
import com.example.lab2.model.Person;
import com.example.lab2.service.PersonCorrelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private PersonCorrelationService personCorrelationService;
    @GetMapping
    public List<Person> getAllStrings() {
        var list = new ArrayList<Person>();
        list.add(personCorrelationService.getAvgPerson(0));
        list.add(personCorrelationService.getAvgPerson(1));
        return list;
    }
    @PostMapping
    public Map<String, HealthClass> post(@RequestBody Person person) {
        return personCorrelationService.comparePersons(person);
    }
}
