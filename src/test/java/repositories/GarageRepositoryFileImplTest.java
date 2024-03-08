package repositories;

import model.car.Car;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import readFromFile.ReadFromFile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GarageRepositoryFileImplTest {

    private GarageRepository garageRepository;
    @BeforeEach
    void setUp() {
        garageRepository = new GarageRepositoryFileImpl();
    }
    @AfterAll
    public static void cleanUp() {
    }

    @Test
    void getToGarage() {
        List<Car> parkedCars = new ArrayList<>(ReadFromFile.getCars());
        garageRepository.getToGarage();
        assertNotNull(parkedCars);

    }

}