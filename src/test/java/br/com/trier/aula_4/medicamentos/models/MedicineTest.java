package br.com.trier.aula_4.medicamentos.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.medicamentos.enums.EnumUses;

class MedicineTest {

	private Medicine medicine;

    @BeforeEach
    void init() {
        List<String> contraindications = new ArrayList<>();
        List<String> recommendations = new ArrayList<>();
        contraindications.add("Alergia à macaco");
        recommendations.add("Gripe");
        medicine = new Medicine("Demazopam", EnumUses.INJECTABLE, contraindications, recommendations);
    }

    @Test
    @DisplayName("Teste do método isRecommended com recomendação existente")
    void testIsRecommendedExistingRecommendation() {
        boolean isRecommended = medicine.isRecommended("Gripe");
        assertTrue(isRecommended);
    }

    @Test
    @DisplayName("Teste do método isRecommended com recomendação não existente")
    void testIsRecommendedNonExistingRecommendation() {
        boolean isRecommended = medicine.isRecommended("Dor de cabeça");
        assertFalse(isRecommended);
    }

    @Test
    @DisplayName("Teste do método isContraindicated com alergia existente")
    void testIsContraindicatedExistingAllergy() {
        List<String> allergies = Arrays.asList("Alergia à macaco", "Alergia a pólen");
        boolean isContraindicated = medicine.isContraindicated(allergies);
        assertTrue(isContraindicated);
    }

    @Test
    @DisplayName("Teste do método isContraindicated com alergia não existente")
    void testIsContraindicatedNonExistingAllergy() {
        List<String> allergies = Arrays.asList("Alergia a pólen", "Alergia a gatos");
        boolean isContraindicated = medicine.isContraindicated(allergies);
        assertFalse(isContraindicated);
    }

    @Test
    @DisplayName("Teste do método toString")
    void testToString() {
        String expectedString = "Demazopam - Uso: Injetável\n";
        String actualString = medicine.toString();
        assertEquals(expectedString, actualString);
    }
    
    @Test
    @DisplayName("Teste do construtor ")
    void testConstructorWithEmptyLists() {
        Medicine emptyMedicine = new Medicine("EmptyMedicine", EnumUses.ORAL, new ArrayList<>(), new ArrayList<>());
        assertNotNull(emptyMedicine);
        assertEquals("EmptyMedicine", emptyMedicine.getName());
        assertEquals(EnumUses.ORAL, emptyMedicine.getType());
        assertEquals(0, emptyMedicine.getContraindications().size());
        assertEquals(0, emptyMedicine.getRecommendations().size());
    }

}
