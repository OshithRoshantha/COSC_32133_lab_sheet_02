package com.example.labSheet02.Service.Implementaion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.labSheet02.Model.Student;
import com.example.labSheet02.Repository.StudentRepository;
import com.example.labSheet02.Service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentRepository studentRepoInstance;

    public Student addStudent(Student newStudent){
        return studentRepoInstance.save(newStudent);
    }

    public Student searchStudent(long id){
        return studentRepoInstance.findById(id).get();
    }

    public Student updateStudent(long id,Student updatedStudent){
        Student matchedStudent=studentRepoInstance.findById(id).get();
        matchedStudent.setFirstName(updatedStudent.getFirstName());
        matchedStudent.setLastName(updatedStudent.getLastName());
        matchedStudent.setEmail(updatedStudent.getEmail());
        matchedStudent.setDepartment(updatedStudent.getDepartment());
        matchedStudent.setYearOfEnrollment(updatedStudent.getYearOfEnrollment());
        studentRepoInstance.save(matchedStudent);
        return matchedStudent;
    }

    public void removeStudent(long id){
        studentRepoInstance.deleteById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepoInstance.findAll();
    }
}
