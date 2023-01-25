package com.example.demo.service;

import com.example.demo.entity.Car;
import com.example.demo.repostory.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CarsService {

    @Autowired
    private CarRepository carsRepository;

    public Integer save(Car vO) {
        Car bean = new Car();
        BeanUtils.copyProperties(vO, bean);
        bean = carsRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        carsRepository.deleteById(id);
    }

    public void update(Integer id, Car vO) {
        Car bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        carsRepository.save(bean);
    }


    private Car requireOne(Integer id) {
        return carsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public Car getById(Integer id) {
        Car original = requireOne(id);
        return original;
    }


}
