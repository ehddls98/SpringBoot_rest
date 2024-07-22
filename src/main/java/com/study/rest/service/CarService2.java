package com.study.rest.service;

import com.study.rest.entity.Car2;
import com.study.rest.repository.CarRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService2 {

    @Autowired
    CarRepository2 carRepository2;

    public Car2 getCar(String model) {
        return carRepository2.findCarByCarModel(model);
    }
}
