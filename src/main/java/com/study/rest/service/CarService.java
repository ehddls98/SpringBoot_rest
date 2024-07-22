package com.study.rest.service;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    //@AutoWired 를 사용하지 않았을때

//    @NonNull: null일 수 없는 변수에 달아준다. final과 같은 의미
//    private final CarRepository carRepository;
//    final -> 상수: 무조건 한번은 생성자를 통해 초기화를 해줘야 한다.

//    public CarService(CarRepository carRepository) {
//        this.carRepository = carRepository;
//        //여기서 carRepository 를 생성하여 위의 상수에 대입한다.(초기화)
//    }

    @Autowired
    CarRepository carRepository;

    public Car getCar(String model) {
        return carRepository.findCarByModel(model);
    }
}


