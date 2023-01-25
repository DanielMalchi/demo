package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.TeachersService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/teachers")
public class TeachersController {

    @Autowired
    private TeachersService teachersService;

    @PostMapping

    public String save(@Valid @RequestBody Teacher vO) {
        return teachersService.save(vO).toString();
    }

    @DeleteMapping("/")

    public void delete(@Valid @NotNull @RequestParam("id") String id) {
        teachersService.delete(id);
    }

    @PutMapping("/")
    public void update(@Valid @NotNull @RequestParam("id") String id,
                       @Valid @RequestBody Teacher vO) {
        teachersService.update(id, vO);
    }

    @GetMapping("/")
    public Teacher getById(@Valid @NotNull @RequestParam("id") String id) {
        return teachersService.getById(id);
    }

}
