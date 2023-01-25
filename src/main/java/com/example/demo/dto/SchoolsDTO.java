package com.example.demo.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class SchoolsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String title;

    private String managerName;

    private Integer amountOfTeachers;

    private String city;

}
