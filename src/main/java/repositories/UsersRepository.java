package repositories;

import model.User;

import java.util.List;

public interface UsersRepository {
    void create(User user);

    User findById(String id);

    List<User> findAll();

    void update(String id, User user);

    List<User> deleteById(String id);

    void deleteAll();
}
