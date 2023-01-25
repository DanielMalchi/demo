package com.example.demo.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class StudentsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private String IDTeacher;

    private String gender;

}
