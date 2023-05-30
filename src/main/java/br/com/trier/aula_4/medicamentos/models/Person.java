package br.com.trier.aula_4.medicamentos.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Person {
	private Integer id;
	private String name;
	private String symptom;
	private List<String> allergies;
	private List<Medicine> prescriptions;
	
	public Person(String name, String symptom, List<String> allergies, List<Medicine> prescriptions) {
		super();
		this.name = name;
		this.symptom = symptom;
		this.allergies = allergies;
		this.prescriptions = prescriptions;
	}
	
	public void setPrescriptions(Medicine medicine) {
		try {
			if(medicine.isContraindicated(allergies)) {
				throw new Exception("Medicamento contraindicado!");
			}else if(!medicine.isRecommended(symptom)) {
				throw new Exception("Medicamento não recomendado para este sintoma!");
			}
			prescriptions.add(medicine);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void newAllergie(String allergie) {
		allergies.add(allergie);
	}
	
	@Override
	public String toString() {
		return this.name + " [Medicamentos]\n" + prescriptions.toString();
	}

	
}
