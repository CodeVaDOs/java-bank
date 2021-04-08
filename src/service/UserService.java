package service;

import dao.AbstractDao;
import dao.UserDao;
import entity.User;

import java.util.Optional;

public class UserService {
    private final UserDao dao = new UserDao();

    public Optional<User> createUser(String login, String pin) {
        if (dao.getByLogin(login).isPresent()) return Optional.empty();

        User user = new User(login, pin);

        User savedUser = dao.save(user);
        return Optional.of(savedUser);
    }

    public Optional<User> authUser(String login, String pin) {
        return dao.getByLogin(login).filter(u -> u.validatePin(pin));
    }
}
