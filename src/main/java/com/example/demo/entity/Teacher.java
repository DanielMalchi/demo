package com.example.demo.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Teachers", schema = "dbo", catalog = "driveProject")
public class Teacher {
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
    @Column(name = "gender", nullable = false)
    private String gender;
    @Basic
    @Column(name = "IDSchool", nullable = false)
    private int idSchool;
    @Basic
    @Column(name = "IDCar", nullable = false)
    private int idCar;

}

