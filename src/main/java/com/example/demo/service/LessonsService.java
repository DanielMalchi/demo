package com.example.demo.service;

import com.example.demo.entity.Lesson;
import com.example.demo.repostory.LessonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LessonsService {

    @Autowired
    private LessonRepository lessonsRepository;

    public Integer save(Lesson vO) {
        Lesson bean = new Lesson();
        BeanUtils.copyProperties(vO, bean);
        bean = lessonsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        lessonsRepository.deleteById(id);
    }

    public void update(Integer id, Lesson vO) {
        Lesson bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        lessonsRepository.save(bean);
    }

    public Lesson getById(Integer id) {
        Lesson original = requireOne(id);
        return original;
    }

    private Lesson requireOne(Integer id) {
        return lessonsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }


}
