package com.example.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        List<Student> students = studentRepository.findAll();

        return students;
    }
    public void addStudent(Student student) {

        studentRepository.save(student);
    }
}
