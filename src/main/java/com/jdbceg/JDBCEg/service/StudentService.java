package com.jdbceg.JDBCEg.service;

import com.jdbceg.JDBCEg.model.Student;
import com.jdbceg.JDBCEg.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    @Autowired // wiring service and repository objects
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(Student student) {
        studentRepository.saveStudentInRepository(student);
        //System.out.println("Student added");
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAllStudents();
    }
}
