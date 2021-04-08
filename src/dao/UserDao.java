package dao;

import entity.User;

import java.util.Optional;

public class UserDao extends AbstractDao<User> {
    public Optional<User> getByLogin(String login) {
        return this.dataCollection.stream()
                .filter(u -> u.getLogin().equalsIgnoreCase(login))
                .findFirst();
    }
}
