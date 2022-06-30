package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;


@Entity
@Table
@Data
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;

    @Transient
    private Integer age;

    public Integer getAge(){
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}
