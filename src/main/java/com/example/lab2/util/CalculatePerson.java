package com.example.lab2.util;

import com.example.lab2.model.BloodCharacteristics;
import com.example.lab2.model.Person;
import com.example.lab2.model.PressureCharacteristics;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatePerson {
    public Person getAvgPerson(List<Person> personsList, String id) {
        int height = 0;
        int weight = 0;
        float temp = 0;
        List<PressureCharacteristics> pressureCharacteristics = new ArrayList<>();
        List<BloodCharacteristics> bloodCharacteristics = new ArrayList<>();
        int size = personsList.size();
        for(var person : personsList) {
            height += person.getHeight();
            weight += person.getWeight();
            temp += person.getTemperature();
            pressureCharacteristics.add(person.getPressureCharacteristics());
            bloodCharacteristics.add(person.getBloodCharacteristics());
        }
        return Person.build(
                id,
                height/size,
                weight/size,
                temp/size,
                avgPressure(pressureCharacteristics),
                avgBlood(bloodCharacteristics)
        );
    }
    private PressureCharacteristics avgPressure(List<PressureCharacteristics> pressureCharacteristics) {
        int pressureH = 0;
        int pressureL = 0;
        int pulse = 0;
        int size = pressureCharacteristics.size();
        for(var pressure : pressureCharacteristics) {
            pressureH += pressure.getPressureHigh();
            pressureL += pressure.getPressureLow();
            pulse += pressure.getPulse();
        }
        return PressureCharacteristics.build(
                pressureH/size,
                pressureL/size,
                pulse/size
        );

    }
    private BloodCharacteristics avgBlood(List<BloodCharacteristics> bloodCharacteristics) {
        int leikocites = 0;
        int coe = 0;
        int mioglobin = 0;
        int kholeterine = 0;
        int gemoglobin = 0;
        int neitrofily = 0;
        int trombocity = 0;
        int gematokrit = 0;

        int size = bloodCharacteristics.size();
        for(var blood : bloodCharacteristics) {
            leikocites += blood.getLeikocites();
            coe += blood.getCoe();
            mioglobin += blood.getMioglobin();
            kholeterine += blood.getKholeterine();
            gemoglobin  += blood.getGemoglobin();
            neitrofily += blood.getNeitrofily();
            trombocity += blood.getTrombocity();
            gematokrit += blood.getGematokrit();
        }
        return BloodCharacteristics.build(
                coe/size,
                gematokrit/size,
                kholeterine/size,
                leikocites/size,
                neitrofily/size,
                trombocity/size,
                mioglobin/size,
                gemoglobin/size
        );

    }

}
