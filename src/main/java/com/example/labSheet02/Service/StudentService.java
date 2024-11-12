package com.example.labSheet02.Service;

import java.util.List;

import com.example.labSheet02.Model.Student;

public interface StudentService {
    Student addStudent(Student newStudent);
    Student searchStudent(long id);
    Student updateStudent(long id,Student updatedStudent);
    void removeStudent(long id);
    String departmentById(long id);
    void removeByYear(int year);
    List<Student> getAllStudents();
    List<Student> getStudentByYear(int year);
}
