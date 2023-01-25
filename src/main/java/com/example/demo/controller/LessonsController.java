package com.example.demo.controller;

import com.example.demo.entity.Lesson;
import com.example.demo.service.LessonsService;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/lessons")
public class LessonsController {

    @Autowired
    private LessonsService lessonsService;

    @PostMapping

    public String save(@Valid @RequestBody Lesson vO) {
        return lessonsService.save(vO).toString();
    }

    @DeleteMapping("/")

    public void delete(@Valid @NotNull @RequestParam("id") Integer id) {
        lessonsService.delete(id);
    }

    @PutMapping("/")

    public void update(@Valid @NotNull @RequestParam("id") Integer id,
                       @Valid @RequestBody Lesson vO) {
        lessonsService.update(id, vO);
    }

    @GetMapping("/")

    public Lesson getById(@Valid @NotNull @RequestParam("id") Integer id) {
        return lessonsService.getById(id);
    }


}
