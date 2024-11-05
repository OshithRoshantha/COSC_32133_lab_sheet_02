package com.example.labSheet02.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.labSheet02.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    
}
