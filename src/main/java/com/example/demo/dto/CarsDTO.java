package com.example.demo.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class CarsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String description;

    private String licenseNumber;

}
