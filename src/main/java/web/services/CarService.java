package web.services;

import org.springframework.stereotype.Service;
import web.model.Car;


import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

    private final List<Car> cars = Arrays.asList(
            new Car("Toyota", "Red", 2010),
            new Car("BMW", "Black", 2015),
            new Car("Audi", "White", 2018),
            new Car("Lada", "Blue", 2020),
            new Car("Honda", "Gray", 2022)
    );

    public List<Car> getCars(Integer count) {
        return count >= cars.size() ? cars : cars.subList(0, count);
    }
}
