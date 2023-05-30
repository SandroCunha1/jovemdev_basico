package br.com.trier.aula_4.medicamentos.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.medicamentos.enums.EnumUses;

class PersonTest {

		List<Person> persons = new ArrayList<>();
		List<Medicine> medicines = new ArrayList<>();
	@BeforeEach
	void init() {
		persons.clear();
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
		persons.add(p1);
	
	}
	
	@Test
	void settingPrescriptionCorrect() {
		persons.get(0).setPrescriptions(medicines.get(0));
		assertEquals(1, persons.get(0).getPrescriptions().size());
		
	}
	
	@Test
	void settingPrescriptionContraindicated() {
		persons.get(0).newAllergie("Alergia á macaco");
		persons.get(0).setPrescriptions(medicines.get(0));
		assertEquals(0, persons.get(0).getPrescriptions().size());
		
	}
	
	@Test
	void settingPrescriptionNotRecommended() {
		persons.get(0).setSymptom("Tosse");
		persons.get(0).setPrescriptions(medicines.get(0));
		assertEquals(0, persons.get(0).getPrescriptions().size());
		
	}
	
	

}
