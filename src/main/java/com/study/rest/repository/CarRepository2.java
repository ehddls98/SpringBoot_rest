package com.study.rest.repository;

import com.study.rest.entity.Car2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository2 {

    private List<Car2> car2List = List.of(
            Car2.builder().model("K3").color("회색").build(),
            Car2.builder().model("K8").color("흰색").build()
    );

    public Car2 findCarByCarModel(String model) {
        Car2 findCar = null;
        for(Car2 car2 : car2List) {
            if (car2.getModel().equals(model)) {
                findCar = car2;
                break;
            }
        }
        return findCar;
    }
}
