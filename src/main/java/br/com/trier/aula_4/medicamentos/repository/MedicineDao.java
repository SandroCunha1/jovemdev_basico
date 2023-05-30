package br.com.trier.aula_4.medicamentos.repository;

import java.util.ArrayList;
import java.util.List;
import br.com.trier.aula_4.medicamentos.models.Medicine;

public class MedicineDao {
	private List<Medicine> bd = new ArrayList<>();

    public Medicine create(Medicine medicine) {
    	medicine.setId(bd.size() + 1);
        bd.add(medicine);
    
        return medicine;
    }
    
    public Medicine findById(final Integer id) {
        return bd.stream()
                .filter(p -> id.equals(p.getId()))
                .findAny()
                .orElse(null);
    }

    public Medicine delete(final Integer id) {
        Medicine personMedicineoDelete = findById(id);

        if (personMedicineoDelete != null) {
            bd.removeIf(p -> id.equals(p.getId()));
        }

        return personMedicineoDelete;
    }

    public void clearData() {
        bd.clear();
    }
    public List<Medicine> getAll() {
        return bd;
    }
	
    
    

}


