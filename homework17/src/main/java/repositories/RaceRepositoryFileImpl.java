package repositories;

import model.race.Race;
import readFromFile.ReadFromFile;
import readFromFile.WriteToFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class RaceRepositoryFileImpl implements RaceRepository {

    @Override
    public List<Race> getRace() {
        List<Race> raceType = ReadFromFile.getRaceFromFile();
        return raceType;

    }

    @Override
    public void creatRace(Race race) {
        try {
            BufferedWriter bufferedWriter = WriteToFile.getBufferedWriterRace();
            bufferedWriter.write(race + "\n");
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи :" + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void deleteAllRace() {
        WriteToFile.clearFileRace();
    }
}
