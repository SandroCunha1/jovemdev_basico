package br.com.trier.aula_4.medicamentos.models;

import java.util.ArrayList;
import java.util.List;
import br.com.trier.aula_4.medicamentos.enums.EnumUses;
import lombok.Getter;

@Getter
public class Medicine implements Identifiable {
	private int id;
	private String name;
	private EnumUses type;
	private List<String> contraindications = new ArrayList<>();
	private List<String> recommendations = new ArrayList<>();
	
	public Medicine(String name, EnumUses type, List<String> contraindications, List<String> recommendations) {
		this.name = name;
		this.type = type;
		this.contraindications = contraindications;
		this.recommendations = recommendations;
	}
	
	public boolean isRecommended(String symptom) {
		return recommendations.contains(symptom);
	}
	
	public boolean isContraindicated(List<String> allergies) {
		return contraindications
					.stream()
					.anyMatch(allergies::contains);
	}
	
	@Override
	public String toString() {
		return this.name + " - Uso: " + type.getDescription() + "\n";
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
