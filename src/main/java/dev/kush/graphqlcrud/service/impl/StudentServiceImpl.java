package dev.kush.graphqlcrud.service.impl;

import dev.kush.graphqlcrud.model.Student;
import dev.kush.graphqlcrud.repository.StudentRepository;
import dev.kush.graphqlcrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Override
    public Student addStudent(String name,String email,String password) {
        return studentRepository.save(new Student(name, email, password));
    }

    @Override
    public Student getStudentById(Long id) {
        return findById(id);
    }

    private Student findById(Long id) {
        return studentRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student deleteStudent(Long id) {
        Student student = findById(id);
        studentRepository.delete(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        Student existingStudent = findById(student.getId());

        if (student.getName() != null && !student.getName().isEmpty()) {
            existingStudent.setName(student.getName());
        }

        if (student.getEmail()!= null &&!student.getEmail().isEmpty()) {
            existingStudent.setEmail(student.getEmail());
        }

        if (student.getPassword()!= null &&!student.getPassword().isEmpty()) {
            existingStudent.setPassword(student.getPassword());
        }

        return studentRepository.save(existingStudent);
    }
}
