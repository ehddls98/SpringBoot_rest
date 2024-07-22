package com.study.rest.Controller;

import com.study.rest.entity.Car;
import com.study.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @ResponseBody
    @GetMapping("/car")
    public Car getCar(@RequestParam String model) {
        return carService.getCar(model);
    }
}

/**
 * 요청 GET - /car?model=K5
 * Car       -> model, color
 *
 * CarRepository    -> Car findCarByModel(String model)
 *      -> List<Car>
 *          -> index0: Car(model: "쏘나타", color: "화이트") model: "쏘나타", color: "화이트" 이 형식으로 response가 와야함
 *          -> index1: Car(model: "K5", color: "블랙")
 *
 * CarService       -> Car getCar(String model)
 *
 * CarController    -> Car getCar(@RequestParam String model)
 *
 * 의존성이 없는 것부터 만든다.
 * CarController > CarService > CarRepository
 */