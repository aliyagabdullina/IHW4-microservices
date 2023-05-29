package services;

import model.User;
import repos.UserRepository;

import java.sql.SQLException;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String email, String password, String role) throws SQLException {
        // Проверка наличия пользователя с таким же именем
        if (userRepository.getUserByUsername(username) != null) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }
        if (email.length() < 5 || !email.contains("@") || !email.contains(".")) {
            throw new RuntimeException("Неверный формат пароля");
        }

        // Создание нового пользователя
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        // Сохранение пользователя в репозитории
        userRepository.createUser(user);
    }

    public User login(String username, String password) {
        User user = userRepository.getUserByUsername(username);

        // Проверка совпадения имени пользователя и пароля
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        throw new RuntimeException("Неверное имя пользователя или пароль");
    }

    public User getUserInfo(String token) {
        User user = userRepository.getUserByToken(token);
        return user;
    }
}
