package com.example.lab2;

import com.example.lab2.model.Person;
import com.example.lab2.service.PersonCorrelationService;
import com.example.lab2.util.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.List;

@SpringBootApplication
public class Lab2Application {
	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

}
