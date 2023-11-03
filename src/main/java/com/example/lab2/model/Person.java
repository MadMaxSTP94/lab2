package com.example.lab2.model;
import com.example.lab2.util.properties.CharProperties;
import lombok.Builder;
import lombok.Data;
import java.util.Map;

@Data
@Builder
public class Person {
    private String id;
    private int height;
    private int weight;
    private float temperature;
    private PressureCharacteristics pressureCharacteristics;
    private BloodCharacteristics bloodCharacteristics;
    public static Person build(Map<String, String> node, CharProperties properties) {
        var associations = properties.getValues();
        return Person.builder()
                .id(node.get("id"))
                .height(Integer.parseInt(node.get(associations.get("height"))))
                .weight(Integer.parseInt(node.get(associations.get("weight"))))
                .temperature(Float.parseFloat(node.get(associations.get("temp"))))
                .pressureCharacteristics(PressureCharacteristics.build(node, associations))
                .bloodCharacteristics(BloodCharacteristics.build(node, associations))
                .build();
    }
}
