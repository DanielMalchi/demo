package com.example.demo.service;

import com.example.demo.entity.School;
import com.example.demo.repostory.SchoolRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SchoolsService {

    @Autowired
    private SchoolRepository schoolsRepository;

    public Integer save(School vO) {
        School bean = new School();
        BeanUtils.copyProperties(vO, bean);
        bean = schoolsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        schoolsRepository.deleteById(id);
    }

    public void update(Integer id, School vO) {
        School bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        schoolsRepository.save(bean);
    }

    public School getById(Integer id) {
        School original = requireOne(id);
        return original;
    }


    private School requireOne(Integer id) {
        return schoolsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

}
