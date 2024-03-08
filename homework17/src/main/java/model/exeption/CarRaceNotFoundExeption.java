package model.exeption;

public class CarRaceNotFoundExeption extends IllegalArgumentException {

    static final String MESSAGE = "Машина с данным номером не найдена";

    public CarRaceNotFoundExeption() {
        super(MESSAGE);
    }
}
