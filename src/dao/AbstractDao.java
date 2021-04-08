package dao;

import entity.AbstractEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractDao<T extends AbstractEntity> implements Dao<T> {
    protected List<T> dataCollection = new ArrayList<>();
    private Long idCounter = 0L;

    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(dataCollection);
    }

    @Override
    public Optional<T> getById(Long id) {
        return dataCollection.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public T save(T t) {
        if (this.dataCollection.contains(t)) {
            int indexOfElement = this.dataCollection.indexOf(t);
            this.dataCollection.set(indexOfElement, t);
        } else {
            t.setId(++this.idCounter);
            this.dataCollection.add(t);
        }
        return t;
    }

    @Override
    public boolean delete(T t) {
        return this.dataCollection.remove(t);
    }

    @Override
    public boolean deleteById(Long id) {
        int size = this.dataCollection.size();
        this.dataCollection = this.dataCollection.stream()
                .filter(t -> !t.getId().equals(id))
                .collect(Collectors.toList());
        return size != this.dataCollection.size();
    }
}
