package com.example.lab2.model;

import lombok.Builder;
import lombok.Data;
import java.util.Map;
@Data
@Builder
public class PressureCharacteristics {
    private Integer pressureLow;
    private Integer pressureHigh;
    private Integer pulse;
    public static PressureCharacteristics build(Map<String, String> node, Map<String,String> associations) {
        return PressureCharacteristics.builder()
                .pressureLow(Integer.parseInt(node.get(associations.get("pressureL"))))
                .pressureHigh(Integer.parseInt(node.get(associations.get("pressureH"))))
                .pulse(Integer.parseInt(node.get(associations.get("pulse"))))
                .build();
    }
    public static PressureCharacteristics build(Integer pressureHigh, Integer pressureLow, Integer pulse) {
        return PressureCharacteristics.builder()
                .pressureLow(pressureLow)
                .pressureHigh(pressureHigh)
                .pulse(pulse)
                .build();
    }
}
