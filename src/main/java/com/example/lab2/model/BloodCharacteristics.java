package com.example.lab2.model;

import com.example.lab2.util.properties.CharProperties;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Data
@Builder
public class BloodCharacteristics {
    private Integer leikocites;
    private Integer coe;
    private Integer mioglobin;
    private Integer kholeterine;
    private Integer gemoglobin;
    private Integer neitrofily;
    private Integer trombocity;
    private Integer gematokrit;
    public static BloodCharacteristics build(Map<String, String> node, Map<String, String> associations) {
        return BloodCharacteristics.builder()
                .coe(Integer.parseInt(node.get(associations.get("coe"))))
                .gematokrit(Integer.parseInt(node.get(associations.get("gematokrit"))))
                .kholeterine(Integer.parseInt(node.get(associations.get("hol"))))
                .leikocites(Integer.parseInt(node.get(associations.get("lei"))))
                .neitrofily(Integer.parseInt(node.get(associations.get("nei"))))
                .trombocity(Integer.parseInt(node.get(associations.get("trom"))))
                .mioglobin(Integer.parseInt(node.get(associations.get("mio"))))
                .gemoglobin(Integer.parseInt(node.get(associations.get("gem"))))
                .build();
    }
    public static BloodCharacteristics build(Integer coe, Integer gematokrit, Integer kholeterine, Integer leikocites, Integer neitrofily,
                                             Integer trombocity, Integer mioglobin, Integer gemoglobin) {
        return BloodCharacteristics.builder()
                .coe(coe)
                .gematokrit(gematokrit)
                .kholeterine(kholeterine)
                .leikocites(leikocites)
                .neitrofily(neitrofily)
                .trombocity(trombocity)
                .mioglobin(mioglobin)
                .gemoglobin(gemoglobin)
                .build();
    }


}
