package com.example.lab2.controller;

import com.example.lab2.model.Person;
import com.example.lab2.util.Parser;
import com.example.lab2.util.PersonRowMapper;
import com.example.lab2.util.properties.CharProperties;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private Parser parser;
    @Autowired
    private Workbook workbook;
    @Autowired
    private PersonRowMapper personRowMapper;
    @Autowired
    private CharProperties charProperties;
    @GetMapping
    public List<Person> getAllStrings() {
        var list = parser.getPersonList(workbook, charProperties.getAssociations());
        var rs = personRowMapper.personList(list.get(0));
        return rs;
    }
}
