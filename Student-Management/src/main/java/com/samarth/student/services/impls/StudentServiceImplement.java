package com.samarth.student.services.impls;

import com.samarth.student.Entities.Student;
import com.samarth.student.dtos.StudentDto;
import com.samarth.student.repositaries.StudentRepo;
import com.samarth.student.services.StudentServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImplement implements StudentServices {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ModelMapper mapper;
    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        Student student = mapper.map(studentDto, Student.class);

        Student save = studentRepo.save(student);
        return mapper.map(save,StudentDto.class);
    }

    @Override
    public StudentDto updateStudent(int studentId, StudentDto studentDto) {

        Student dbStudent = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student not found with given id !!"));

        dbStudent.setStudentName(studentDto.getStudentName());
        dbStudent.setStudentRollNo(studentDto.getStudentRollNo());
        dbStudent.setCity(studentDto.getCity());
        dbStudent.setMark(studentDto.getMark());

        Student updated = studentRepo.save(dbStudent);
        return mapper.map(updated,StudentDto.class);
    }

    @Override
    public void deleteStudent(int studentId) {

        Student dbStudent = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student not found with given id !!"));

        studentRepo.delete(dbStudent);


    }

    @Override
    public StudentDto getSingle(int studentId) {
        Student dbStudent = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student not found with given id !!"));
        return mapper.map(dbStudent,StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudent() {

        List<Student> student = studentRepo.findAll();

        List<StudentDto> studentDtos = student.stream().map(std -> mapper.map(std, StudentDto.class)).collect(Collectors.toList());

        return studentDtos;
    }

    @Override
    public List< StudentDto> searchStudent(String name) {
        List<Student> student = studentRepo.findByStudentNameContaining(name);
        List<StudentDto> studentDtos = student.stream().map(std -> mapper.map(std, StudentDto.class)).collect(Collectors.toList());

        return studentDtos;
    }
}
