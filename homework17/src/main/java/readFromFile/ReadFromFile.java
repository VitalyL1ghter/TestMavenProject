package readFromFile;

import model.car.Car;
import model.car.PerformanceCar;
import model.car.ShowCar;
import model.race.Race;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    private static final String PATH_RACE = "homework17/src/resources/raceOutput.csv";
    private static final String PATH_OUT_CAR = "homework17/src/resources/carOutput.csv";

    public static List<Race> getRaceFromFile() {
        List<Race> raceType = new ArrayList<>();
        try (BufferedReader raceReader = new BufferedReader(new FileReader(PATH_RACE))) {
            String lineRace = raceReader.readLine();
            while (lineRace != null) {
                String[] liner = lineRace.split("\\|");
                raceType.add(new Race(liner[0], Integer.parseInt(liner[1]),
                        liner[2], Integer.parseInt(liner[3])));
                lineRace = raceReader.readLine();

            }
            raceType.forEach(race -> {
                System.out.println(race);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        return raceType;
    }

    public static List<PerformanceCar> getPerformanceCarFromFile() {
        List<PerformanceCar> performanceCar = new ArrayList<>();
        try (BufferedReader carsReader = new BufferedReader(new FileReader(PATH_OUT_CAR))) {
            String lines = carsReader.readLine();
            while (lines != null) {
                String[] line = lines.split("\\|");
                if (Integer.parseInt(line[5]) >= 360) {
                    performanceCar.add(new PerformanceCar(line[0], line[1], line[2], Integer.parseInt(line[3]),
                            Integer.parseInt(line[4]), Integer.parseInt(line[5]),
                            Integer.parseInt(line[6]), Integer.parseInt(line[7])));
                }
                lines = carsReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return performanceCar;
            }
        public static List<ShowCar> getShowCarFromFile() {
        List<ShowCar> showCar = new ArrayList<>();
        try (BufferedReader carsReader = new BufferedReader(new FileReader(PATH_OUT_CAR))) {
            String lines = carsReader.readLine();
            while (lines != null) {
                String[] line = lines.split("\\|");
                if (Integer.parseInt(line[5]) < 360) {
                    showCar.add(new ShowCar(line[0], line[1], line[2], Integer.parseInt(line[3]),
                            Integer.parseInt(line[4]), Integer.parseInt(line[5]),
                            Integer.parseInt(line[6]), Integer.parseInt(line[7]), 0));
                }
                lines = carsReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return showCar;
    }
    public static List<Car> getCars() {
        List<Car> car = new ArrayList<>();
        try (BufferedReader carsReader = new BufferedReader(new FileReader(PATH_OUT_CAR))) {
            String lines = carsReader.readLine();
            while (lines != null) {
                String[] line = lines.split("\\|");
                car.add(new Car(line[0], line[1], line[2], Integer.parseInt(line[3]),
                        Integer.parseInt(line[4]), Integer.parseInt(line[5]),
                        Integer.parseInt(line[6]), Integer.parseInt(line[7])));
                lines = carsReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
}




