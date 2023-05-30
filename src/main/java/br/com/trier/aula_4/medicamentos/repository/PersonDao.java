package br.com.trier.aula_4.medicamentos.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_4.medicamentos.models.Person;

public class PersonDao {
	private List<Person> bd = new ArrayList<>();

    public Person create(Person person) {
    	person.setId(bd.size() + 1);
        bd.add(person);
    
        return person;
    }

    public Person findById(final Integer id) {
        return bd.stream()
                .filter(p -> id.equals(p.getId()))
                .findAny()
                .orElse(null);
    }

    public Person delete(final Integer id) {
        Person personPersonoDelete = findById(id);

        if (personPersonoDelete != null) {
            bd.removeIf(p -> id.equals(p.getId()));
        }

        return personPersonoDelete;
    }

    public void clearData() {
        bd.clear();
    }
    public List<Person> getAll() {
        return bd;
    }  
    
    public String showAllPersonsAndMedicines(){
    	return getAll().toString();
    }
	
}
