import model.User;
import repositories.UsersRepositoryFileImpl;

import java.time.LocalDateTime;
import java.util.List;

public class App {

    public static void main(String[] args) {
        UsersRepositoryFileImpl checkWork = new UsersRepositoryFileImpl();

        List<User> users = List.of(
                new User("3bca433a-71f5-4ed8-9357-486d8ee3cbab", LocalDateTime.now(), "nik1", "a3e24",
                        "a3e24", "Крылов", "Виктор", "Павлович", 25, true),
                new User("2e62f299-25e6-4fe4-b33d-7434d630d7b7", LocalDateTime.now(), "nik2", "3r2",
                        "3r2", "Копылов", "Петр", "Иванович", 18, true),
                new User("aa60452c-5fe5-4c13-9ffb-f12f40c53f82", LocalDateTime.now(), "nik3", "rw5",
                        "rw5", "Smit", "Jonny", null, 32, false),
                new User("847eacdd-e8aa-4533-9117-2ff1ecbf99bd", LocalDateTime.now(), "nik4", "qwe_1",
                        "qwe_1", "Иванов", "Иван", "Иванович", 0, true),
                new User("14b7701e-30f4-4932-b7aa-fb52896cf3f8", LocalDateTime.now(), "nik5", "rrr_23",
                        "rrr_23", "Сидоров", "Николай", "Денисович", 24, false));

        for (User user : users) {
            checkWork.create(user);
        }

        checkWork.create(new User("921c1457-09bc-481f-9ac1-00ac147f42f9", LocalDateTime.now(), "nik6", "aqwr6",
                "aqwr6", "Черный", "Олег", "Гаврилович", 49, true));

        System.out.println("Все пользователи базы: ");
        checkWork.findAll().forEach(System.out::println);

        System.out.println("Поиск пользователя по id: " + checkWork.findById("847eacdd-e8aa-4533-9117-2ff1ecbf99bd"));

        System.out.println("Удален пользователь с id 847eacdd-e8aa-4533-9117-2ff1ecbf99bd");
        checkWork.deleteById("847eacdd-e8aa-4533-9117-2ff1ecbf99bd");

        System.out.println("Пользователь id  921c1457-09bc-481f-9ac1-00ac147f42f9 был обновлен на пользователя " +
                "с id 47b7701y-30f5-4933-b7ac-fb52896cr333 ");
        System.out.println("Пользователи базы после удаления и замены пользователя");
        checkWork.update("921c1457-09bc-481f-9ac1-00ac147f42f9",
                new User("47b7701y-30f5-4933-b7ac-fb52896cr333", LocalDateTime.now(), "nik555", "tttt",
                        "tttt", "Петров", "Петр", "Петрович", 47, false));

        System.out.println("Пользователи удаленны");
        checkWork.deleteAll();

    }
}
