package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
            .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email Taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {

        validateStudentId(studentId);
        studentRepository.deleteById(studentId);
    }

    private void validateStudentId(Long studentId) {
        boolean existsById = studentRepository.existsById(studentId);
        if (!existsById) {
            throw new IllegalStateException("Student by id " + studentId + " does not exist!");
        }
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(
            () -> new IllegalStateException("Student by id " + studentId + " does not exist!")
        );
        if (name != null && name.length() > 0 && !student.getName().equals(name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !student.getEmail().equals(email)) {
            Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email Taken!");
            }
            student.setEmail(email);
        }
    }
}
