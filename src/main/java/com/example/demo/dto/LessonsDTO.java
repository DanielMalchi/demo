package com.example.demo.dto;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class LessonsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String IDStudent;

    private LocalDateTime orderDate;

    private LocalDateTime lessonDate;

    private String description;

    private Double price;

}
