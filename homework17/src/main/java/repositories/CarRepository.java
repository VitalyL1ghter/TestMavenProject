package repositories;

import model.car.Car;
import model.car.PerformanceCar;
import model.car.ShowCar;

import java.util.List;

public interface CarRepository {

    List<PerformanceCar> getPerformanceCars();

    List<ShowCar> getShowCars();

    List<Car> getCar();

    public void createCar(Car car);

    public Car findByID(String id_number);

    void delleteAllCar();

}
