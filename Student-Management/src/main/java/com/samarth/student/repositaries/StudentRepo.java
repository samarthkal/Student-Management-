package com.samarth.student.repositaries;

import com.samarth.student.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Integer> {

   List< Student> findByStudentNameContaining(String name);
}
