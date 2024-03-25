package repositories;

import model.car.Car;
import model.garage.Garage;

import java.util.List;

public interface GarageRepository {

    List<Car> getToGarage();

    void deleteAllGarage();

}
