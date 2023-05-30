package br.com.trier.aula_4.medicamentos.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.medicamentos.enums.EnumUses;
import br.com.trier.aula_4.medicamentos.models.Medicine;
import br.com.trier.aula_4.medicamentos.models.Person;

class PersonDaoTest {

	PersonDao persons = new PersonDao();
	MedicineDao medicines = new MedicineDao();
	List<String> allergies;
	List<Medicine> prescriptions;

	@BeforeEach
	void init() {
		persons.clearData();
		medicines.clearData();
		
		List<String> contraindications = new ArrayList<>();
		List<String> recommendations = new ArrayList<>();
		contraindications.add("Alergia á macaco");
		recommendations.add("Gripe");
		Medicine m1 = new Medicine("Demazopam", EnumUses.INJECTABLE, contraindications, recommendations);
		medicines.create(m1);
		
		allergies = new ArrayList<>();
		allergies.add("Abelha");
		prescriptions = new ArrayList<>();
		Person p1 = new Person("Joãozinho", "Gripe", allergies, prescriptions);
		p1.setPrescriptions(m1);
		persons.create(p1);
	}
	
	@Test
	@DisplayName("Teste do método findById com ID existente")
	void testFindByIdExistingPerson() {
		Person person = persons.findById(1);
		assertEquals("Joãozinho", person.getName());
		assertEquals("Gripe", person.getSymptom());
	}
	
	@Test
	@DisplayName("Testando o metodo findById em um pessoa que não existe")
	void testFindByIdNonExistingPerson() {
		Person person = persons.findById(2);
		assertEquals(null , person);
	}
	
	@Test
    @DisplayName("Teste do método findById com ID existente depois de remover e mexer na lista")
    void testFindByIdExistingMedicineAfterRemoving() {
		Person p1 = new Person("Joãozinho", "Gripe", allergies, prescriptions);
		persons.create(p1);
        persons.delete(2);
        Person p2 = new Person("Joãozinho", "Gripe", allergies, prescriptions);
		persons.create(p2);
        Person person = persons.findById(3);
        assertEquals("Joãozinho", person.getName());
        assertEquals("Gripe", person.getSymptom());
    }
	
	@Test
	@DisplayName("Teste do método delete com ID existente")
    void testDeleteExistingId() {
        Person deletedPerson = persons.delete(1);
        assertNotNull(deletedPerson);
        assertEquals(1, deletedPerson.getId());
        assertEquals("Joãozinho", deletedPerson.getName());
        assertEquals(0, persons.getAll().size());
    }
	
	@Test
	@DisplayName("Teste do método delete com ID não existente")
	void testDeleteNonExistingId() {
		Person deletedPerson = persons.delete(2);
		assertNull(deletedPerson);
	}
	
	@Test
    @DisplayName("Teste do método clearData")
    void testClearData() {
        persons.clearData();
        assertEquals(0, persons.getAll().size());
    }	
	
	@Test
	@DisplayName("Teste do método getAll")
	void testIfGetAllIsGettinAll() {
		persons.create(new Person(null, null, null, null));
		assertEquals(2, persons.getAll().size());
	}
	
	@Test
	@DisplayName("Teste do método showAllPersonsAndMedicines se não existir nenhuma pessoa")
	void testListOfPersonsAndHisPrescriptionIfThereIsNoPerson() {
		persons.clearData();
		
		assertEquals("[]", persons.showAllPersonsAndMedicines());
	}
	
	@Test
	@DisplayName("Teste do método showAllPersonsAndMedicines")
	void testListOfPersonsAndHisPrescription() {
		
		assertEquals("[1 Joãozinho [Medicamentos]\n"
				+ "[Demazopam - Uso: Injetável\n"
				+ "]]", persons.showAllPersonsAndMedicines());
	}

}
