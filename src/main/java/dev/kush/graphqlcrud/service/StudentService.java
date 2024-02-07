package dev.kush.graphqlcrud.service;

import dev.kush.graphqlcrud.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(String name,String email,String password);
    Student getStudentById(Long id);
    List<Student> getAll();

    Student deleteStudent(Long id);

    Student updateStudent(Student student);
}
