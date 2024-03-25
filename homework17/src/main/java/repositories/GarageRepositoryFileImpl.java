package repositories;

import model.car.Car;
import readFromFile.ReadFromFile;
import readFromFile.WriteToFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GarageRepositoryFileImpl implements GarageRepository {
    @Override
    public List<Car> getToGarage() {
        List<Car> cars = new ArrayList<>(ReadFromFile.getCars());
        List<Car> parkedCars = new ArrayList<>();
        parkedCars.add(cars.get(new Random().nextInt(cars.size())));
        try {
            BufferedWriter bufferedWriter = WriteToFile.getToGarageCar();
            bufferedWriter.write(parkedCars + "\n");
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Ошибка записи :" + e.getMessage());
            e.printStackTrace(System.out);
        }
        return parkedCars;
    }

    @Override
    public void deleteAllGarage() {
        WriteToFile.clearFileGarage();
    }
}



