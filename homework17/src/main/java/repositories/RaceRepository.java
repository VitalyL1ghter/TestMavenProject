package repositories;

import model.race.Race;

import java.util.List;

public interface RaceRepository {

    List<Race> getRace();

    public void creatRace(Race race);

    void deleteAllRace();

}
