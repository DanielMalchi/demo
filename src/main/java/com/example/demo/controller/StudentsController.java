package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repostory.StudentRepository;
import com.example.demo.service.StudentsService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @PostMapping("/save")
    public String save(@Valid @RequestBody Student vO) {
        return studentsService.save(vO).toString();
    }

    @DeleteMapping("/")
    public void delete(@Valid @NotNull @RequestParam("id") String id) {
        studentsService.delete(id);
    }

    @PutMapping("/")
    public void update(@Valid @NotNull @RequestParam("id") String id,
                       @Valid @RequestBody Student vO) {
        studentsService.update(id, vO);
    }

    @GetMapping("/")
    public Student getById(@Valid @NotNull @RequestParam("id") String id) {
        return studentsService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return studentsService.getAllStudents();
    }


}
