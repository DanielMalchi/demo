package com.example.demo.controller;

import com.example.demo.entity.School;
import com.example.demo.service.SchoolsService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/schools")
public class SchoolsController {

    @Autowired
    private SchoolsService schoolsService;

    @PostMapping
    
    public String save(@Valid @RequestBody School vO) {
        return schoolsService.save(vO).toString();
    }

    @DeleteMapping("/")
    
    public void delete(@Valid @NotNull @RequestParam("id") Integer id) {
        schoolsService.delete(id);
    }

    @PutMapping("/")
    
    public void update(@Valid @NotNull @RequestParam("id") Integer id,
                       @Valid @RequestBody School vO) {
        schoolsService.update(id, vO);
    }

    @GetMapping("/")
    
    public School getById(@Valid @NotNull @RequestParam("id") Integer id) {
        return schoolsService.getById(id);
    }

}
