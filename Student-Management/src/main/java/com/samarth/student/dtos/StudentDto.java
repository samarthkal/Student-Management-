package com.samarth.student.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {

    private int studentID;


    private String studentName;

    private int studentRollNo;
    private String city;
    private int mark;
}
