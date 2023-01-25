package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.repostory.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TeachersService {

    @Autowired
    private TeacherRepository teachersRepository;

    public String save(Teacher vO) {
        Teacher bean = new Teacher();
        BeanUtils.copyProperties(vO, bean);
        bean = teachersRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        teachersRepository.deleteById(id);
    }

    public void update(String id, Teacher vO) {
        Teacher bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        teachersRepository.save(bean);
    }

    public Teacher getById(String id) {
        Teacher original = requireOne(id);
        return original;
    }


    private Teacher requireOne(String id) {
        return teachersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }


}
