package repositories;

import model.car.Car;
import model.car.PerformanceCar;
import model.car.ShowCar;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import readFromFile.ReadFromFile;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@ExtendWith(MockitoExtension.class)
class CarRepositoryFileImplTest {

    private CarRepository carRepository;
    @BeforeEach
    void setUp() {
        carRepository = new CarRepositoryFileImpl();
    }
    @AfterAll
    public static void cleanUp() {
    }
    @Test
    void PerformanceCars_Not_Null() {
        List<PerformanceCar> performanceCars = new ArrayList<>(ReadFromFile.getPerformanceCarFromFile());
        assertNotNull(performanceCars.size());

    }
    @Test
    void ShowCars_Not_Null() {
        List<ShowCar> showCars = new ArrayList<>(ReadFromFile.getShowCarFromFile());
        assertNotNull(showCars.size());
    }
    @Test
    void Car_Not_Null() {
        List<Car> cars = new ArrayList<>(ReadFromFile.getCars());
        assertNotNull(cars.size());
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/carOutput.csv", delimiterString = "|")
    void Car_Not_Null_CSV(String id_number, String brand,
                          String model, Integer manufactureYear,
                          Integer power, Integer acceleration, Integer suspension,
                          Integer durability) {
        Car car = new Car(id_number, brand, model, manufactureYear, power, acceleration, suspension, durability);
        carRepository.createCar(car);
        assertNotNull(carRepository.getCar());
    }
    @Test
    void createCar() {
        carRepository.createCar(new Car("TTTTT", "TEST",
                "TEST", 2000, 1000,
                500, 100, 10));
        List<Car> cars = carRepository.getCar();
        assertNotNull(cars.size());

    }
    @ParameterizedTest
    @CsvSource(value = {
            "RRRR, Lexus, lexus, 2010, 500, 300, 90, 15"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void testCreateCar(String id_number, String brand,
                       String model, Integer manufactureYear,
                       Integer power, Integer acceleration, Integer suspension,
                       Integer durability) {
        List<Car> cars = new ArrayList<>();
        Car car = new Car(id_number, brand, model, manufactureYear, power, acceleration, suspension, durability);
        carRepository.createCar(car);
        assertNotNull(cars);
        assertNotNull(brand);
        assertNotNull(power);
        assertNotNull(durability);

    }
    @Test
    void findByID_CarNumber() {
        carRepository.createCar(new Car("R777R", "Lexus",
                "RX", 2015, 750,
                420, 89, 16));
        carRepository.getCar();
        Car carId = carRepository.findByID("R777R");
        assert carId != null;
        assertEquals(carId.getId_number(), "R777R");
    }
    @Test
    void delleteAllCar() {
        carRepository.delleteAllCar();
        List<Car> cars = carRepository.getCar();
        assert cars.isEmpty();
    }
}