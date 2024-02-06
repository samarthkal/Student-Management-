package com.samarth.student.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentID;

    @Column(name = "student_name")
    private String studentName;
    @NonNull
    private int studentRollNo;
    private String city;
    private int mark;
}
