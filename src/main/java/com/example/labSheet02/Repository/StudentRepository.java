package com.example.labSheet02.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.labSheet02.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByYearOfEnrollment(int year);
}
