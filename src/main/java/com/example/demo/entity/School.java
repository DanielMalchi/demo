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
@Table(name = "Schools", schema = "dbo", catalog = "driveProject")
public class School {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "title", nullable = false)
    private String title;
    @Basic
    @Column(name = "managerName", nullable = false)
    private String managerName;
    @Basic
    @Column(name = "AmountOfTeachers", nullable = false)
    private int amountOfTeachers;
    @Basic
    @Column(name = "city", nullable = false)
    private String city;

}

