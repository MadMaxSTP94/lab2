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
            "id","Рост","Вес","Давление нижн.","Давление верх.",
            "Температура","Пульс","Лейкоциты","СОЭ","Миоглобин",
            "Холестирин",	"Гемоглобин", "Нейтрофилы",	"Тромбоциты","Гематокрит"

    ).stream().collect(Collectors.toList());
    @PostConstruct
    public void init() {
        values = new HashMap<>();
        values.put("id", "id");
        values.put("height", "Рост");
        values.put("weight", "Вес");
        values.put("pressureH", "Давление верх.");
        values.put("pressureL", "Давление нижн.");
        values.put("temp", "Температура");
        values.put("pulse", "Пульс");
        values.put("lei", "Лейкоциты");
        values.put("coe", "СОЭ");
        values.put("mio", "Миоглобин");
        values.put("hol", "Холестирин");
        values.put("gem", "Гемоглобин");
        values.put("nei", "Нейтрофилы");
        values.put("trom", "Тромбоциты");
        values.put("gematokrit", "Гематокрит");

    }
}
