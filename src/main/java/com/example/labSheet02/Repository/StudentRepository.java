package com.example.labSheet02.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.labSheet02.Model.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{
    List<Student> findByYearOfEnrollment(int year);

    @Query(value="select department from student where id = :id", nativeQuery=true)
    String findDepartmentById(@Param("id") Long id);

    @Query(value="delete from student where year_of_enrollment=:year", nativeQuery=true)
    void removeEnrollments(@Param("year") int year);
}
