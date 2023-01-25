package com.example.demo.controller;

import com.example.demo.entity.Car;
import com.example.demo.service.CarsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Validated
@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @PostMapping
    public String save(@Valid @RequestBody Car vO) {
        return carsService.save(vO).toString();
    }

    @DeleteMapping("/")
    public void delete(@Valid @NotNull @RequestParam("id") Integer id) {
        carsService.delete(id);
    }

    @PutMapping("/")

    public void update(@Valid @NotNull @RequestParam("id") Integer id,
                       @Valid @RequestBody Car vO) {
        carsService.update(id, vO);
    }

    @GetMapping("/")

    public Car getById(@Valid @NotNull @RequestParam("id") Integer id) {
        return carsService.getById(id);
    }


}
