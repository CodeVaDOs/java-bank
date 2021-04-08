package dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    List<T> getAll();

    Optional<T> getById(Long id);

    T save(T t);

    boolean delete(T t);

    boolean deleteById(Long id);
}
