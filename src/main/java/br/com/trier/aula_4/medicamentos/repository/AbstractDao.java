package br.com.trier.aula_4.medicamentos.repository;
import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_4.medicamentos.models.Identifiable;

public abstract class AbstractDao<T extends Identifiable> {
    protected List<T> bd = new ArrayList<>();

    public T create(T item) {
        item.setId(bd.size() + 1);
        bd.add(item);

        return item;
    }

    public T findById(final Integer id) {
        return bd.stream()
                .filter(item -> id.equals(item.getId()))
                .findAny()
                .orElse(null);
    }

    public T delete(final Integer id) {
        T itemToDelete = findById(id);
        if (itemToDelete != null) {
            bd.removeIf(item -> id.equals(item.getId()));
        }

        return itemToDelete;
    }

    public void clearData() {
        bd.clear();
    }

    public List<T> getAll() {
        return bd;
    }
}

