package fhallengreen.morecars.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "car")
@NoArgsConstructor
@Getter
@Setter
public class Car {

    @Id
    private int id;
    String brand;
    String model;
    String color;
    int kilometers;
    @CreationTimestamp
    LocalDate created;
    @UpdateTimestamp
    LocalDate updated;



}
