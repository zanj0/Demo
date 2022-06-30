package com.example.demo.student;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sun.tools.javac.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return  args -> {
            Student sharmistha = new Student();

            sharmistha.setEmail("sharmistha@gmail.com");
            sharmistha.setName("Sharmistha");
            sharmistha.setDateOfBirth(LocalDate.of(1986,9,13));

            Student arnab = new Student();

            arnab.setEmail("arnab@gmail.com");
            arnab.setName("Arnab");
            arnab.setDateOfBirth(LocalDate.of(1976,10,31));

            repository.saveAll(List.of(sharmistha, arnab));
        };
    }
}
