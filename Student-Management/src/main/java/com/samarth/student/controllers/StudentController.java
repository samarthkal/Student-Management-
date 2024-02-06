package com.samarth.student.controllers;

import com.samarth.student.dtos.StudentDto;
import com.samarth.student.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServices services;

    @PostMapping
    public ResponseEntity<StudentDto>createStudent( @RequestBody StudentDto studentDto){
        StudentDto student = services.createStudent(studentDto);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto>update(@PathVariable int studentId,@RequestBody StudentDto studentDto){

        StudentDto updateStudent = services.updateStudent(studentId, studentDto);

        return  new ResponseEntity<>(updateStudent,HttpStatus.CREATED);


    }
    @GetMapping
    public ResponseEntity<List<StudentDto>>getAll(){

        List<StudentDto> allStudent = services.getAllStudent();
        return new ResponseEntity<>(allStudent,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto>getSingle(@PathVariable int id){

        StudentDto single = services.getSingle(id);

        return new ResponseEntity<>(single,HttpStatus.OK);


    }

    @DeleteMapping("{id}")
    public ResponseEntity<String > deleteStudent(@PathVariable int id){

        services.deleteStudent(id);

        return new ResponseEntity<>("student deleted successfully !!",HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<StudentDto>>search(@PathVariable String name){

        List<StudentDto> studentDtos = services.searchStudent(name);

        return new ResponseEntity<>(studentDtos,HttpStatus.OK);
    }
}
