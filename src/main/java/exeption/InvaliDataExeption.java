package exeption;

import model.User;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class InvaliDataExeption {
    public static void validUser(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            throw new InputMismatchException("ID Пользователя не может быть пустым полем ");
        }
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new InputMismatchException("Логин не может быть пустой строкой ");
        } else if (Pattern.matches("[(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$_-]\s+",
                user.getLogin())) {
            throw new InputMismatchException("Логин должен состоять из латинских букв, цифр и символов  ");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InputMismatchException("Пароль не может быть пустой строкой");
        } else if (Pattern.matches("[(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$_-]\s+",
                user.getPassword())) {
            throw new InputMismatchException("Пароль должен состоять из латинских букв, цифр и символов ");
        }
        if (user.getFirstName() == null || user.getFirstName().isEmpty()) {
            throw new InputMismatchException("Фамилия и имя должны быть, состоять из букв ");
        } else if (Pattern.matches("[a-zA-Zа-яА-Я ]\s+", user.getFirstName())) {
            throw new InputMismatchException("Фамилия и имя должны быть, состоять из букв ");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new InputMismatchException("Фамилия и имя должны быть, состоять из букв ");
        } else if (Pattern.matches("[a-zA-Zа-яА-Я ]\s+", user.getFirstName())) {
            throw new InputMismatchException("Фамилия и имя должны быть, состоять из букв ");
        }

    }
}
