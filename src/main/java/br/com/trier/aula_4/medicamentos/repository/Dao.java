package br.com.trier.aula_4.medicamentos.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class Dao<T> {
    private List<T> bd = new ArrayList<>();

    public T create(T person) {
        bd.add(person);
        getPersonId(person);
        return person;
    }

    public T findById(final Integer id) {
        return bd.stream()
                .filter(p -> id.equals(getPersonId(p)))
                .findAny()
                .orElse(null);
    }

    public T delete(final Integer id) {
        T personToDelete = findById(id);

        if (personToDelete != null) {
            bd.removeIf(p -> id.equals(getPersonId(p)));
        }

        return personToDelete;
    }

    public void clearData() {
        bd.clear();
    }
    public List<T> getAll() {
        return bd;
    }
    
    protected abstract Integer getPersonId(T person);
}
