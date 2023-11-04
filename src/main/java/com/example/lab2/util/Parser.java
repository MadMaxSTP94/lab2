package com.example.lab2.util;

import com.example.lab2.model.HealthClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class Parser {
    private final String TEMP_CONST = "Температура";
    public List<List<Map<String, String>>> getPersonList(Workbook workbook, List<String> associations) {
        List<List<Map<String, String>>> list = new ArrayList<>();
        var iterator = workbook.iterator();
        while (iterator.hasNext()) {
            Sheet sheet = iterator.next();
            if(sheet.getSheetName().equals(HealthClass.HEALTHY.name()) || sheet.getSheetName().equals(HealthClass.ILL.name())) {
                List<Map<String, String>> innerList = new ArrayList<>();
                for (Row row : sheet) {
                    Map<String, String> inInnerList = getStringStringMap(associations, row);
                    innerList.add(inInnerList);
                }
                list.add(innerList);
            }
        }
        return list;
    }

    private Map<String, String> getStringStringMap(List<String> associations, Row row) {
        Map<String, String> inInnerList = new HashMap<>();
        int counter = 0;
        for (Cell cell : row) {
            switch (cell.getCellType()) {
                case STRING:
                    inInnerList.put(associations.get(counter),cell.getStringCellValue());
                    break;
                case NUMERIC:
                    if(associations.get(counter).equals(TEMP_CONST))
                        inInnerList.put(associations.get(counter), cell.getNumericCellValue()+"");
                    else inInnerList.put(associations.get(counter),(int) cell.getNumericCellValue()+"");
                    break;
            }
            counter++;
        }
        return inInnerList;
    }
}
