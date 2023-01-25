package com.example.demo.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students", schema = "dbo", catalog = "driveProject")
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private String id;
    @Basic
    @Column(name = "firstName", nullable = false)
    private String firstName;
    @Basic
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Basic
    @Column(name = "phone", nullable = false)
    private String phone;
    @Basic
    @Column(name = "address", nullable = false)
    private String address;
    @Basic
    @Column(name = "IDTeacher", nullable = false)
    private String idTeacher;
    @Basic
    @Column(name = "gender", nullable = false)
    private String gender;
}

