package model.car;
import lombok.Data;
import java.util.ArrayList;
import java.util.StringJoiner;

@Data

public class PerformanceCar extends Car {

    private final ArrayList<String > addOns = new ArrayList<>();

    public PerformanceCar(String id_number, String brand, String model, Integer manufactureYear,
                          Integer power, Integer acceleration, Integer suspension, Integer durability) {
        super(id_number, brand, model, manufactureYear, power, acceleration, suspension, durability);
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
                .toString();
    }
}
