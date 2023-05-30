package br.com.trier.aula_4.medicamentos.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.medicamentos.enums.EnumUses;
import br.com.trier.aula_4.medicamentos.models.Medicine;

class MedicineDaoTest {

	private MedicineDao medicines;

    List<String> contraindications = new ArrayList<>();
    List<String> recommendations = new ArrayList<>();
    @BeforeEach
    void init() {
        medicines = new MedicineDao();
        medicines.clearData();

        contraindications = new ArrayList<>();
        recommendations = new ArrayList<>();
        contraindications.add("Alergia à macaco");
        recommendations.add("Gripe");
        Medicine m1 = new Medicine("Demazopam", EnumUses.INJECTABLE, contraindications, recommendations);
        medicines.create(m1);
    }

    @Test
    @DisplayName("Teste do método findById com ID existente")
    void testFindByIdExistingMedicine() {
        Medicine medicine = medicines.findById(1);
        assertEquals("Demazopam", medicine.getName());
        assertEquals(EnumUses.INJECTABLE, medicine.getType());
    }
    
    @Test
    @DisplayName("Teste do método findById com ID existente depois de remover e mexer na lista")
    void testFindByIdExistingMedicineAfterRemoving() {
    	Medicine m1 = new Medicine("Neosaudina", EnumUses.INJECTABLE, contraindications, recommendations);
        medicines.create(m1);
        medicines.delete(2);
        Medicine m2 = new Medicine("Capetina", EnumUses.INJECTABLE, contraindications, recommendations);
        medicines.create(m2);
        Medicine medicine = medicines.findById(3);
        assertEquals("Capetina", medicine.getName());
        assertEquals(EnumUses.INJECTABLE, medicine.getType());
    }

    @Test
    @DisplayName("Teste do método findById com ID não existente")
    void testFindByIdNonExistingMedicine() {
        Medicine medicine = medicines.findById(2);
        assertNull(medicine);
    }

    @Test
    @DisplayName("Teste do método delete com ID existente")
    void testDeleteExistingId() {
        Medicine deletedMedicine = medicines.delete(1);
        assertNotNull(deletedMedicine);
        assertEquals(1, deletedMedicine.getId());
        assertEquals("Demazopam", deletedMedicine.getName());
        assertEquals(0, medicines.getAll().size());
    }

    @Test
    @DisplayName("Teste do método delete com ID não existente")
    void testDeleteNonExistingId() {
        Medicine deletedMedicine = medicines.delete(2);
        assertNull(deletedMedicine);
    }

    @Test
    @DisplayName("Teste do método clearData")
    void testClearData() {
        medicines.clearData();
        assertEquals(0, medicines.getAll().size());
    }

    @Test
    @DisplayName("Teste do método getAll")
    void testGetAll() {
        medicines.create(new Medicine(null, null, null, null));
        assertEquals(2, medicines.getAll().size());
    }
}


