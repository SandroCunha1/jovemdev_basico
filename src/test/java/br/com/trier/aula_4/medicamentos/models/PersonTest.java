package br.com.trier.aula_4.medicamentos.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.medicamentos.enums.EnumUses;

class PersonTest {

    private Person person;
    private List<Medicine> medicines;

    @BeforeEach
    void init() {
        medicines = new ArrayList<>();
        medicines.clear();

        List<String> contraindications = new ArrayList<>();
        List<String> recommendations = new ArrayList<>();
        contraindications.add("Alergia à macaco");
        recommendations.add("Gripe");
        Medicine m1 = new Medicine("Demazopam", EnumUses.INJECTABLE, contraindications, recommendations);
        medicines.add(m1);

        List<String> allergies = new ArrayList<>();
        allergies.add("Abelha");
        List<Medicine> prescriptions = new ArrayList<>();
        person = new Person("Joãozinho", "Gripe", allergies, prescriptions);
    }
	
	@Test
	@DisplayName("Teste do método setPrescriptions com prescrição correta")
	void testSetPrescriptionsCorrect() {
		person.setPrescriptions(medicines.get(0));
		assertEquals(1, person.getPrescriptions().size());
	}
	
	@Test
	@DisplayName("Teste do método setPrescriptions com medicamento contraindicado")
	void testSetPrescriptionsContraindicated() {
		person.newAllergie("Alergia à macaco");
		person.setPrescriptions(medicines.get(0));
		assertEquals(0, person.getPrescriptions().size());
	}
	
	@Test
	@DisplayName("Teste do método setPrescriptions com medicamento não recomendado")
	void testSetPrescriptionsNotRecommended() {
		person.setSymptom("Tosse");
		person.setPrescriptions(medicines.get(0));
		assertEquals(0, person.getPrescriptions().size());
	}
	
	@Test
    @DisplayName("Teste do método newAllergie")
    void testNewAllergie() {
        person.newAllergie("Poeira");
        assertTrue(person.getAllergies().contains("Poeira"));
    }

    @Test
    @DisplayName("Teste do método toString")
    void testToString() {
        String expectedString = "0 Joãozinho [Medicamentos]\n"
        		+ "[]";
        String actualString = person.toString();
        assertEquals(expectedString, actualString);
    }
	
	

}
