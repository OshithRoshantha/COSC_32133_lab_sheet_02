package com.example.labSheet02.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.labSheet02.Model.Student;
import com.example.labSheet02.Service.StudentService;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentServiceInstance;

    @GetMapping("/SMS/students")
    public List<Student> getAllStudents(){
        return studentServiceInstance.getAllStudents();
    }

    @GetMapping("/SMS/students/{year}")
    public List<Student> getByYear(@PathVariable int year){
        return studentServiceInstance.getStudentByYear(year);
    }

    @GetMapping("/SMS/department/{id}")
    public ResponseEntity<String> searchDepartmentById(@PathVariable long id){
        return new ResponseEntity<>(studentServiceInstance.departmentById(id),HttpStatus.FOUND);
    }

    @PostMapping("/SMS/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student newStudent){
        return new ResponseEntity<>(studentServiceInstance.addStudent(newStudent),HttpStatus.CREATED);
    }

    @DeleteMapping("/SMS/remove/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable Long id){
        studentServiceInstance.removeStudent(id);
        return new ResponseEntity<>("Student Removed!",HttpStatus.OK);
    }

    @PostMapping("/SMS/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student updatedStudent){
        return new ResponseEntity<>(studentServiceInstance.updateStudent(updatedStudent.getId(), updatedStudent),HttpStatus.OK);
    }

    @GetMapping("/SMS/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return new ResponseEntity<>(studentServiceInstance.searchStudent(id),HttpStatus.FOUND);
    }
}
