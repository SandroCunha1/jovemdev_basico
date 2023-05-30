package br.com.trier.aula_4.medicamentos.repository;

import br.com.trier.aula_4.medicamentos.models.Medicine;

public class MedicineDao extends Dao<Medicine> {
	private static int lastId = 0;
    @Override
    protected Integer getPersonId(Medicine medicine) {
    	if (medicine.getId() == null) {
            lastId++;
            medicine.setId(lastId);
        }
        return medicine.getId();
    }
    

}


