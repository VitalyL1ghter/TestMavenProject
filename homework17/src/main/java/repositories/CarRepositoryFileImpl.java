package repositories;
import model.car.Car;
import model.car.PerformanceCar;
import model.car.ShowCar;
import model.exeption.CarRaceNotFoundExeption;
import readFromFile.ReadFromFile;
import readFromFile.WriteToFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarRepositoryFileImpl implements CarRepository {

    @Override
    public List<PerformanceCar> getPerformanceCars() {
        List<PerformanceCar> performanceCars = ReadFromFile.getPerformanceCarFromFile();
        performanceCars.forEach(System.out::println);
        return performanceCars;
    }

    @Override
    public List<ShowCar> getShowCars() {
        List<ShowCar> showCars = ReadFromFile.getShowCarFromFile();
        showCars.forEach(System.out::println);
        return showCars;
    }

    @Override
    public List<Car> getCar() {
        List<Car> cars = ReadFromFile.getCars();
        for (Car carsNew : cars) {
            System.out.println(carsNew);
        }
        return cars;
    }

    public void createCar(Car car) {
        try {
            BufferedWriter bufferedWriter = WriteToFile.getBufferedWriterCar();
            bufferedWriter.write(car + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи :" + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    @Override
    public Car findByID(String id_number) {

        List<Car> cars = new ArrayList<>(ReadFromFile.getCars());
        Car carsN = cars.stream()
                .filter(car -> car.getId_number().contains(id_number))
                .findFirst()
                .orElse(null);
        if (Objects.isNull(carsN)) {
            throw new CarRaceNotFoundExeption();
        }
        return carsN;

    }

    @Override
    public void delleteAllCar() {
        WriteToFile.clearFileCar();

    }
}










