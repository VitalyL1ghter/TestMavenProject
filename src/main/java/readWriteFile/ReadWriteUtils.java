package readWriteFile;

import java.io.*;

public class ReadWriteUtils {

    private static final String PATH = "src/main/resources/userBase.txt";

    public static BufferedWriter getBufferedWriter() {
        try {
            FileWriter writer = new FileWriter(PATH, true);
            return new BufferedWriter(writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedWriter getBufferedReWriter() {
        try {

            FileWriter reWriter = new FileWriter(PATH, false);
            return new BufferedWriter(reWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BufferedReader getBufferedReader() {

        try {
            FileReader reader = new FileReader(PATH);
            return new BufferedReader(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
