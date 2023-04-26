package fhallengreen.morecars.api;

import fhallengreen.morecars.dto.CarResponse;
import fhallengreen.morecars.repository.CarRepository;
import fhallengreen.morecars.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarController {


    CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<CarResponse> getCars(Pageable page) {
        Page<CarResponse> carResponsePage = carService.getCars(page);
        return carResponsePage.getContent();
    }

    @GetMapping("/cars/brand/{brand}")
    public List<CarResponse> getCarsWithBrand(@PathVariable String brand, Pageable pageable){

        return carService.getCarsWithBrand(pageable, brand);
    }

    @GetMapping("/countcars")
    public long countCars(){

        return carService.countCars();

    }
}
