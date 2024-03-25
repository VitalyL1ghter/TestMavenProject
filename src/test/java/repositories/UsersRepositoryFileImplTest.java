package repositories;


import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

class UsersRepositoryFileImplTest {

    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        usersRepository = new UsersRepositoryFileImpl();
    }

    @AfterEach
    void tearDown() {
        usersRepository.deleteAll();
    }

    @Test
    @DisplayName("Тест на добавления пользователя")
    void create() {
        User user = getUser();
        usersRepository.create(user);
        List<User> users = usersRepository.findAll();
        assert users != null;
        assert users.size() == 1;
    }

    @Test
    @DisplayName("Тест на поиск пользователя")
    void findById() {
        User user = getUser();
        usersRepository.create(user);
        User userById = usersRepository.findById(user.getId());
        assert userById != null;
        assert Objects.equals(userById.getId(), user.getId());
    }

    @Test
    @DisplayName("Тест на наличие пользователей")
    void findAll() {
        User user1 = getUser();
        User user2 = getUser();
        usersRepository.create(user1);
        usersRepository.create(user2);
        List<User> users = usersRepository.findAll();
        assert users != null;
        assert users.size() == 2;
    }

    @Test
    @DisplayName("Тест на измененние пользователя")
    void update() {
        User user1 = getUser();
        User user2 = getUser();
        User user3 = getUser();
        user2.setId(UUID.randomUUID().toString());
        usersRepository.create(user1);
        usersRepository.create(user2);
        usersRepository.update(user2.getId(), user3);
        List<User> users = usersRepository.findAll();
        assert users.contains(user3);
        assert users.size() == 2;
    }

    @Test
    @DisplayName("Тест на удаление пользователя")
    void deleteById() {
        User user1 = getUser();
        User user2 = getUser();
        user2.setId(UUID.randomUUID().toString());
        usersRepository.create(user1);
        usersRepository.create(user2);
        usersRepository.deleteById(user1.getId());
        List<User> users = usersRepository.findAll();
        assert users != null;
        assert users.size() == 1;
    }

    @Test
    @DisplayName("Тест на удаление всех ользователей")
    void deleteAll() {
        User user1 = getUser();
        User user2 = getUser();
        user2.setId(UUID.randomUUID().toString());
        usersRepository.create(user1);
        usersRepository.create(user2);
        usersRepository.deleteAll();
        List<User> users = usersRepository.findAll();
        assert users.isEmpty();
    }

    private User getUser() {
        return new User(UUID.randomUUID().toString(), LocalDateTime.now(), "nik1", "a3e24",
                "a3e24", "Крылов", "Виктор", "Павлович", 25, true);
    }
}