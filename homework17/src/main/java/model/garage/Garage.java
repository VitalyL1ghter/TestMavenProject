package model.garage;
import lombok.*;
import model.car.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Garage {
    private List<Car> parkedCars = new ArrayList<>();

    @Override
    public String toString() {
        return new StringJoiner("|")
                .add("" + parkedCars)
                .toString();
    }
}
