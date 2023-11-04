package com.example.lab2.service;

import com.example.lab2.model.BloodCharacteristics;
import com.example.lab2.model.HealthClass;
import com.example.lab2.model.Person;
import com.example.lab2.model.PressureCharacteristics;
import com.example.lab2.util.CalculatePerson;
import com.example.lab2.util.Parser;
import com.example.lab2.util.PersonRowMapper;
import com.example.lab2.util.properties.CharProperties;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class PersonCorrelationService {
    @Autowired
    private Parser parser;
    @Autowired
    private Workbook workbook;
    @Autowired
    private PersonRowMapper personRowMapper;
    @Autowired
    private CharProperties charProperties;
    @Autowired
    private CalculatePerson calculatePerson;

    public Map<String, HealthClass> getResult(Person person) {
        var list = new ArrayList<Person>();
        list.add(getAvgPerson(0));
        list.add(getAvgPerson(1));
        return comparePersons(person);
    }
    public Person getAvgPerson(int id) {
        var list = parser.getPersonList(workbook, charProperties.getAssociations());
        var rs = personRowMapper.personList(list.get(id));
        String identity = id == 0 ? HealthClass.HEALTHY.name() : HealthClass.ILL.name();
        var avgPerson = calculatePerson.getAvgPerson(rs, identity);
        return avgPerson;
    }
    public Map<String, HealthClass> comparePersons(Person comp) {
        Person healthy = getAvgPerson(0);
        Person ill = getAvgPerson(1);
        var names = charProperties.getValues();
        Map<String, HealthClass> fieldHealthClassMap = new HashMap<>();
        fieldHealthClassMap.put(names.get("height"), HealthClass.HEALTHY);
        fieldHealthClassMap.put(names.get("weight"), HealthClass.HEALTHY);
        fieldHealthClassMap.put(names.get("temp"), HealthClass.HEALTHY);
        var compPressure = comparePressure(comp.getPressureCharacteristics(), ill.getPressureCharacteristics(), healthy.getPressureCharacteristics());
        var compBlood = compareBlood(comp.getBloodCharacteristics(), ill.getBloodCharacteristics(), healthy.getBloodCharacteristics());
        fieldHealthClassMap.putAll(compPressure);
        fieldHealthClassMap.putAll(compBlood);
        return fieldHealthClassMap;
    }
    public Map<String, HealthClass> comparePressure(PressureCharacteristics comp, PressureCharacteristics ill, PressureCharacteristics healthy) {
        Map<String, HealthClass> pressureRes = new HashMap<>();
        var names = charProperties.getValues();
        if(healthy.getPulse() <= comp.getPulse() && comp.getPulse() <= ill.getPulse())
            pressureRes.put(names.get("pulse"), HealthClass.HEALTHY);
        else
            pressureRes.put(names.get("pulse"), HealthClass.ILL);
        if(healthy.getPressureLow() <= comp.getPressureLow() && comp.getPressureLow() <= ill.getPressureLow())
            pressureRes.put(names.get("pressureL"), HealthClass.HEALTHY);
        else
            pressureRes.put(names.get("pressureL"), HealthClass.ILL);
        if(healthy.getPressureHigh() <= comp.getPressureHigh() && comp.getPressureHigh() <= ill.getPressureHigh())
            pressureRes.put(names.get("pressureH"), HealthClass.HEALTHY);
        else
            pressureRes.put(names.get("pressureH"), HealthClass.ILL);
        return pressureRes;
    }
    public Map<String, HealthClass> compareBlood(BloodCharacteristics comp, BloodCharacteristics ill ,BloodCharacteristics healthy) {
        Map<String, HealthClass> pressureRes = new HashMap<>();
        var names = charProperties.getValues();
        if(healthy.getLeikocites() <= comp.getLeikocites() && comp.getLeikocites() <= ill.getLeikocites())
            pressureRes.put(names.get("lei"),HealthClass.HEALTHY);
        else
            pressureRes.put(names.get("lei"),HealthClass.ILL);
        if(healthy.getCoe() <= comp.getCoe() && comp.getCoe() <= ill.getCoe())
            pressureRes.put(names.get("coe"),HealthClass.HEALTHY);
        else
            pressureRes.put(names.get("coe"),HealthClass.ILL);
        if(healthy.getMioglobin() <= comp.getMioglobin() && comp.getMioglobin() <= ill.getMioglobin())
            pressureRes.put(names.get("mio"),HealthClass.HEALTHY);
        else
            pressureRes.put(names.get("mio"),HealthClass.ILL);
        pressureRes.put(names.get("hol"), HealthClass.HEALTHY);
        pressureRes.put(names.get("gem"), HealthClass.HEALTHY);
        if(healthy.getNeitrofily() <= comp.getNeitrofily() && comp.getNeitrofily() <= ill.getNeitrofily())
            pressureRes.put(names.get("nei"),HealthClass.HEALTHY);
        else
            pressureRes.put(names.get("nei"),HealthClass.ILL);
        pressureRes.put(names.get("trom"), HealthClass.HEALTHY);
        pressureRes.put(names.get("gematokrit"), HealthClass.HEALTHY);
        return pressureRes;
    }

}
