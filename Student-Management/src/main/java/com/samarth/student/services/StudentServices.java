package com.samarth.student.services;

import com.samarth.student.dtos.StudentDto;

import java.util.List;

public interface StudentServices {

    // create student
    StudentDto createStudent(StudentDto studentDto);

    // update student
    StudentDto updateStudent (int studentId, StudentDto studentDto);

    // delete student

    void  deleteStudent (int studentId);

    // get Single student
    StudentDto getSingle(int studentId);


    //    get All student

    List<StudentDto> getAllStudent();

    //  search student name wise

  List< StudentDto> searchStudent(String name);



}
