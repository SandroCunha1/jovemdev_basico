package br.com.trier.aula_4.medicamentos.repository;


import br.com.trier.aula_4.medicamentos.models.Person;

public class PersonDao extends AbstractDao<Person> {
    public String showAllPersonsAndMedicines(){
    	return getAll().toString();
    }
	
}
