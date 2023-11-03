package com.example.lab2.util.properties;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Component
public class CharProperties {
    private Map<String, String> values;
    public final List<String> associations = List.of(
            "id","����","���","�������� ����.","�������� ����.",
            "�����������","�����","���������","���","���������",
            "����������",	"����������", "����������",	"����������","����������"

    ).stream().collect(Collectors.toList());
    @PostConstruct
    public void init() {
        values = new HashMap<>();
        values.put("id", "id");
        values.put("height", "����");
        values.put("weight", "���");
        values.put("pressureH", "�������� ����.");
        values.put("pressureL", "�������� ����.");
        values.put("temp", "�����������");
        values.put("pulse", "�����");
        values.put("lei", "���������");
        values.put("coe", "���");
        values.put("mio", "���������");
        values.put("hol", "����������");
        values.put("gem", "����������");
        values.put("nei", "����������");
        values.put("trom", "����������");
        values.put("gematokrit", "����������");

    }
}
