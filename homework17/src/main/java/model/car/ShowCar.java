package model.car;
import lombok.*;
import java.util.StringJoiner;
@Data

public class ShowCar extends Car {
    private Integer stars;

    public ShowCar(String id_number, String brand, String model, Integer manufactureYear,
                   Integer power, Integer acceleration, Integer suspension, Integer durability, Integer stars) {
        super(id_number, brand, model, manufactureYear, power, acceleration, suspension, durability);
        this.stars = stars;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

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
                .add("" + stars)
                .toString();
    }
}

