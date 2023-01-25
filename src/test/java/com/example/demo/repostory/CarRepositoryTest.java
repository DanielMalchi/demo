package com.example.demo.repostory;

import com.example.demo.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void saveCar(){
        Car car=Car.builder().description("gsfuce").licenseNumber("959566").build();
        carRepository.save(car);
    }



}