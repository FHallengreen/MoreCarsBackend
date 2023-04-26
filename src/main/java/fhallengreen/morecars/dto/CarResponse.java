package fhallengreen.morecars.dto;

import fhallengreen.morecars.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarResponse {

    int id;
    String brand;
    String model;
    String color;
    int kilometers;

    public CarResponse(Car c) {
        this.id = c.getId();
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.color = c.getColor();
        this.kilometers = c.getKilometers();
    }
}
