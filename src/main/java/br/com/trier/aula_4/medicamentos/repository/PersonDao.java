package br.com.trier.aula_4.medicamentos.repository;

import br.com.trier.aula_4.medicamentos.models.Person;

public class PersonDao<T> extends Dao<Person> {
	private static int lastId = 0;
	
    @Override
    protected Integer getPersonId(Person person) {
    	if (person.getId() == 0) {
            lastId++;
            person.setId(lastId);
        }
        return person.getId();
    }
    
    public String showAllPersonsAndMedicines(){
    	return getAll().toString();
    }
	
}
