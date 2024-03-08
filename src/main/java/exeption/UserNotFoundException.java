package exeption;

public class UserNotFoundException extends IllegalArgumentException{
    static final String MESSAGE = "Пользователя с данным id не найден";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
