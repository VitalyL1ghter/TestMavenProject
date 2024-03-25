package repositories;
import model.race.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import readFromFile.ReadFromFile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
class RaceRepositoryFileImplTest {
    private RaceRepository raceRepository;
    @BeforeEach
    void setUp() {
        raceRepository = new RaceRepositoryFileImpl();
    }
    @Test
    void getRace() {
        List<Race> races = new ArrayList<>(ReadFromFile.getRaceFromFile());
        assertNotNull(races.size());
    }
    @ParameterizedTest
    @CsvSource(value = {"CircuitRace,70,route5,170000", "Test,50,testRout,100000"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void testCreatRace(String type, Integer distance, String route, Integer prizeFound) {
        List<Race> races = new ArrayList<>();
        Race race = new Race(type, distance, route, prizeFound);
        raceRepository.creatRace(race);
        assertNotNull(races);
        assertNotNull(type);
        assertNotNull(distance);
        assertNotNull(prizeFound);

    }
    @Test
    void deleteAllRace() {
        raceRepository.deleteAllRace();
        List<Race> races = raceRepository.getRace();
        assert races.isEmpty();
    }
}