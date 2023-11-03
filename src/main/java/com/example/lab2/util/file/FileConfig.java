package com.example.lab2.util.file;

import com.example.lab2.util.PersonRowMapper;
import com.example.lab2.util.properties.CharProperties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Configuration
@PropertySource("classpath:application.properties")
public class FileConfig {
    @Bean("file")
    public File getFileByName(@Value("${file.name}") String name) {
        return new File(name);
    }
    @Bean("fileInputStream")
    @Autowired
    public FileInputStream fileInputStream(File file) {
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Bean("xssfWorkBook")
    @Autowired
    public Workbook xssfWorkbook(FileInputStream fileInputStream) {
        try {
            return new XSSFWorkbook(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
