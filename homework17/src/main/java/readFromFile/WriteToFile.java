package readFromFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class WriteToFile {
    private static final String PATH_OUT_CAR = "homework17/src/resources/carOutput.csv";
    private static final String PATH_OUT_RACE = "homework17/src/resources/raceOutput.csv";
    private static final String PATH_GARAGE = "homework17/src/resources/garageCarOutput.csv";
    public static BufferedWriter getBufferedWriterCar() {
        try {
            FileWriter writer = new FileWriter(PATH_OUT_CAR, true);
            return new BufferedWriter(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static BufferedWriter getBufferedWriterRace() {
        try {
            FileWriter writer = new FileWriter(PATH_OUT_RACE, true);
            return new BufferedWriter(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static BufferedWriter getToGarageCar() {
        try {
            FileWriter writer = new FileWriter(PATH_GARAGE, true);
            return new BufferedWriter(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void clearFileCar() {
        try {
            PrintWriter writer = new PrintWriter(PATH_OUT_CAR);
            writer.print("");
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }

    public static void clearFileRace() {

        try {
            PrintWriter writer = new PrintWriter(PATH_OUT_RACE);
            writer.print("");
            writer.flush();
            writer.close();

        } catch (Exception e) {

        }
    }

    public static void clearFileGarage() {

        try {
            PrintWriter writer = new PrintWriter(PATH_GARAGE);
            writer.print("");
            writer.flush();
            writer.close();

        } catch (Exception e) {

        }
    }
}
