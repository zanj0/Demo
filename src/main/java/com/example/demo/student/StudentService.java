package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return com.sun.tools.javac.util.List.of(
            new Student(1L,
                        "Agnibha",
                        LocalDate.of(1998, 2, 17),
                        "agnibha@gmail.com", 24 )
        );
    }
}
