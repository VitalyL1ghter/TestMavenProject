package model.race;
import lombok.*;
import model.car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Race {
    private String type;
    private Integer distance;
    private String route;
    private Integer prizeFound;
    private final List<Car> cars = new ArrayList<>();

    @Override
    public String toString() {
        return new StringJoiner("|")
                .add("" + type)
                .add("" + distance)
                .add("" + route + "")
                .add("" + prizeFound)
                .add("" + cars)
                .toString();
    }
}
