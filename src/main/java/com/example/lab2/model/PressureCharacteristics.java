package com.example.lab2.model;

import lombok.Builder;
import lombok.Data;
import java.util.Map;
@Data
@Builder
public class PressureCharacteristics {
    private int pressureLow;
    private int pressureHigh;
    private int pulse;
    public static PressureCharacteristics build(Map<String, String> node, Map<String,String> associations) {
        return PressureCharacteristics.builder()
                .pressureLow(Integer.parseInt(node.get(associations.get("pressureL"))))
                .pressureHigh(Integer.parseInt(node.get(associations.get("pressureH"))))
                .pulse(Integer.parseInt(node.get(associations.get("pulse"))))
                .build();
    }
}
