package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repostory.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentsService {

    @Autowired
    private StudentRepository studentsRepository;

    public String save(Student vO) {
        Student bean = new Student();
        BeanUtils.copyProperties(vO, bean);
        bean = studentsRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        studentsRepository.deleteById(id);
    }

    public void update(String id, Student vO) {
        Student bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        studentsRepository.save(bean);
    }

    public Student getById(String id) {
        Student original = requireOne(id);
        return original;
    }


    private Student requireOne(String id) {
        return studentsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Student> getAllStudents(){
        return studentsRepository.findAll();
    }

}
