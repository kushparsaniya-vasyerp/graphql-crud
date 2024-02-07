package dev.kush.graphqlcrud.controller;

import dev.kush.graphqlcrud.model.Student;
import dev.kush.graphqlcrud.service.StudentService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @QueryMapping(value = "allStudent")
    public List<Student> getAllStudent() {
        return studentService.getAll();
    }

    @QueryMapping(value = "findOne")
    public Student findStudent(@Argument("id") Long id) {
        return studentService.getStudentById(id);
    }

    @MutationMapping("addOne")
    public Student addStudent(
            @Argument("name") String name,
            @Argument("email") String email,
            @Argument("password") String password) {
        return studentService.addStudent(name, email, password);
    }

    @MutationMapping(value = "deleteOne")
    public Student deleteStudent(@Argument("id") Long id) {
        return studentService.deleteStudent(id);
    }


    @MutationMapping(value = "updateOne")
    public Student updateStudent(@Argument("student") Student student){
        return studentService.updateStudent(student);
    }

}
