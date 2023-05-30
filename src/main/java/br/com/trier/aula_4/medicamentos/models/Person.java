package br.com.trier.aula_4.medicamentos.models;

import java.util.List;
import lombok.Getter;

@Getter

public class Person {
	private int id;
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
		return this.id + " "+ this.name + " [Medicamentos]\n" + prescriptions.toString();
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	

	
}
