package com.study.rest.Controller;

import com.study.rest.entity.Car2;
import com.study.rest.service.CarService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController2 {

    @Autowired
    private CarService2 carService2;

    @ResponseBody
    @GetMapping("/car2")
    public Car2 getCar(@RequestParam String model) {
        return carService2.getCar(model);
    }
}
