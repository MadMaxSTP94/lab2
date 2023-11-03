package com.example.lab2.util;

import com.example.lab2.model.BloodCharacteristics;
import com.example.lab2.model.Person;
import com.example.lab2.model.PressureCharacteristics;
import com.example.lab2.util.properties.CharProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class PersonRowMapper {
    private CharProperties properties;
    @Autowired
    public PersonRowMapper(CharProperties properties) {
        this.properties = properties;
    }
    public List<Person> personList(List<Map<String, String>> list) {
        list.remove(0);
        List<Person> rs = new ArrayList<>();
        for (var node : list) {
            rs.add(Person.build(node, properties));
        }
        return rs;
    }
}
