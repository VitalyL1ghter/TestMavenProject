package model.car;

import lombok.*;

import java.util.StringJoiner;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {

    String id_number;

    String brand;

    String model;

    Integer manufactureYear;

    Integer power;

    Integer acceleration;

    Integer suspension;

    Integer durability;

    @Override
    public String toString() {
        return new StringJoiner("|")
                .add("" + id_number)
                .add("" + brand)
                .add("" + model)
                .add("" + manufactureYear)
                .add("" + power)
                .add("" + acceleration)
                .add("" + suspension)
                .add("" + durability)
                .toString();
    }
}




