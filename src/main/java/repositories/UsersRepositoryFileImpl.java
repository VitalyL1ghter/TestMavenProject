package repositories;

import exeption.InvaliDataExeption;
import exeption.UserNotFoundException;
import model.User;
import readWriteFile.ReadWriteUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static readWriteFile.ReadUserFromFile.getUserFromFile;

public class UsersRepositoryFileImpl implements UsersRepository {
    private static final String PATH = "src/main/resources/userBase.txt";

    @Override
    public void create(User user) {
        try {
            InvaliDataExeption.validUser(user);
            BufferedWriter bufferWriter = ReadWriteUtils.getBufferedWriter();
            bufferWriter.write(user + "\n");
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println("Ошибка записи " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }

    @Override
    public User findById(String id) {
        BufferedReader bufferedReader = ReadWriteUtils.getBufferedReader();
        String line = bufferedReader.lines().filter(user -> user.contains(id)).findFirst().orElse(null);
        while (line != null) {
            String[] lines = line.split("\\|");
            User newUserString = new User(lines[0], LocalDateTime.parse(lines[1]),
                    lines[2], lines[3], lines[4], lines[5], lines[6],
                    lines[7], Integer.parseInt(lines[8]), Boolean.valueOf(lines[9]));
            if (Objects.isNull(newUserString)) {
                throw new UserNotFoundException();
            }
            return newUserString;
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> newUserBaseRep = getUserFromFile();
        return newUserBaseRep;
    }

    @Override
    public void update(String id, User user) {

        List<User> newUserBaseRep = getUserFromFile();
        Map<String, User> mapUser = new HashMap<>();
        for (User users : newUserBaseRep) {
            mapUser.put(users.getId(), users);
        }
        if (!mapUser.containsKey(id)) {
            throw new UserNotFoundException();
        }
        mapUser.put(id, user);
        mapUser.forEach((User, users) -> System.out.println(users));

        try {
            BufferedWriter bufferedWriter = ReadWriteUtils.getBufferedReWriter();
            for (User users : mapUser.values()) {
                bufferedWriter.write(users.toString() + "\n");
                bufferedWriter.flush();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> deleteById(String id) {

        List<User> newUserBaseRep = getUserFromFile();
        newUserBaseRep.removeIf(user -> user.getId().equals(id));

        try {
            BufferedWriter bufferedWriter = ReadWriteUtils.getBufferedReWriter();
            for (User users : newUserBaseRep) {
                bufferedWriter.write(users.toString() + "\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return newUserBaseRep;

    }

    @Override
    public void deleteAll() {
        try {
            PrintWriter writer = new PrintWriter(PATH);
            writer.print("");
            writer.flush();
            writer.close();

        } catch (Exception e) {

        }
    }
}
