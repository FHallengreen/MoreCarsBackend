package fhallengreen.morecars.service;

import fhallengreen.morecars.dto.CarResponse;
import fhallengreen.morecars.entity.Car;
import fhallengreen.morecars.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Page<CarResponse> getCars(Pageable page) {
        Page<Car> getCars = carRepository.findAll(page);

        return getCars.map(car -> new CarResponse(car));
    }

    public List<CarResponse> getCarsWithBrand(Pageable pageable, String brand) {
        List<Car> cars = carRepository.findAllByBrand(brand, pageable);
        return cars.stream().map(CarResponse::new).collect(Collectors.toList());
    }

    public long countCars() {
        return carRepository.count();
    }
}
