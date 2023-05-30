package br.com.trier.aula_4.medicamentos.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.medicamentos.enums.EnumUses;
import br.com.trier.aula_4.medicamentos.models.Medicine;
import br.com.trier.aula_4.medicamentos.models.Person;

class PersonDaoTest {

	PersonDao persons = new PersonDao<>();
	List<Medicine> medicines = new ArrayList<>();
@BeforeEach
void init() {
	persons.clearData();
	medicines.clear();
	List<String> contraindications = new ArrayList<>();
	List<String> recommendations = new ArrayList<>();
	contraindications.add("Alergia á macaco");
	recommendations.add("Gripe");
	Medicine m1 = new Medicine("Demazopam", EnumUses.INJECTABLE, contraindications, recommendations);
	medicines.add(m1);
	List<String> allergies = new ArrayList<>();
	allergies.add("Abelha"); 
	List<Medicine> prescriptions = new ArrayList<>();
	Person p1 = new Person("Joãozinho", "Gripe", allergies, prescriptions);
	p1.setPrescriptions(m1);
	persons.create(p1);

}
	@Test
	void testFindById() {
		Person expectedOutput = (Person) persons.findById(1);
		assertEquals(expectedOutput, (Person) persons.findById(1));
	
	}
	
	@Test
	void testListOfPersonsAndHisPrescriptionIfThereIsNoPerson() {
		persons.clearData();
		persons.showAllPersonsAndMedicines();
	
	}

}
