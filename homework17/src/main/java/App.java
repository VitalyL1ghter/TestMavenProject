import model.car.Car;
import model.race.Race;
import repositories.CarRepositoryFileImpl;
import repositories.GarageRepositoryFileImpl;
import repositories.RaceRepositoryFileImpl;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        CarRepositoryFileImpl chekWorkCar = new CarRepositoryFileImpl();
        RaceRepositoryFileImpl chekWorkRace = new RaceRepositoryFileImpl();
        GarageRepositoryFileImpl chekWorkGarage = new GarageRepositoryFileImpl();

        List<Car> cars = List.of(new Car("E613D", "Bugatti",
                        "Verona", 2006, 1200, 420, 89, 15),
                new Car("D345R", "Dodge",
                        "Viper", 2015, 645, 359, 70, 10),
                new Car("K367T", "Lamborghini",
                        "Hurricane", 2014, 602, 380, 90, 13),
                new Car("F004W", "Lotus",
                        "Exile", 2001, 190, 260, 62, 20),
                new Car("P000S", "Mercedes",
                        "SLS", 2010, 569, 410, 85, 14),
                new Car("T0081", "Porsh",
                        "SLS", 2010, 569, 500, 85, 14));
        for (Car car : cars) {
            chekWorkCar.createCar(car);
        }
        System.out.println("Изначальный список машин :");
        chekWorkCar.getCar();

        chekWorkCar.createCar(new Car("P008T", "BMW",
                "X3", 2010, 250, 370, 96, 19));

        chekWorkCar.createCar(new Car("T999E", "Lada",
                "Vesta", 2022, 105, 260, 54, 10));

        System.out.println("Список машин после добавления :");
        chekWorkCar.getCar();

        System.out.println("Список гоночных машин :");
        chekWorkCar.getPerformanceCars();
        System.out.println("Список спортивных машин :");
        chekWorkCar.getShowCars();
        System.out.println("Поиск машины по Номеру: " + chekWorkCar.findByID("D345R"));

        List<Race> races = List.of(new Race("CasualRace", 60, "route1", 100000),
                new Race("DragRace", 90, "route2", 200000),
                new Race("DriftRace", 40, "route3", 140000));
        for (Race race : races) {
            chekWorkRace.creatRace(race);
        }

        chekWorkRace.creatRace(new Race("TimeLimitRace", 80, "route4", 150000));
        System.out.println("Список гонок : ");
        chekWorkRace.getRace();

        System.out.println("Машина в гараже :" + chekWorkGarage.getToGarage());

        Scanner scanner = new Scanner(System.in);
        System.out.println("ОЧИСТИТЬ ФАЙЛЫ: Y или N ");
        String clear = scanner.nextLine();
        boolean clearFile;
        if (clearFile = clear.equalsIgnoreCase("Y")) {
            chekWorkCar.delleteAllCar();
            chekWorkRace.deleteAllRace();
            chekWorkGarage.deleteAllGarage();
        } else {
            scanner.close();
        }
    }
}









