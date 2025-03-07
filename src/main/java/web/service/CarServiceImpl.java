package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements web.service.CarService {
    private final List<Car> cars = List.of(
            new Car("Ferrari", "F150", 2018),
            new Car("Ferrari", "F8", 2019),
            new Car("Ford", "GT40", 1969),
            new Car("Lamborghini", "huracan", 2014),
            new Car("Porsche", "911", 1998)
    );

    @Override
    public List<Car> getCars(int count) {
        if(count <= cars.size() && count > 0) {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
        return cars;
    }

}
