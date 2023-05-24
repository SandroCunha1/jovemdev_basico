package br.com.trier.aula_3.biblioteca;

public enum EnumGender {

	MASCULINO(1, "Masculino"),
	FEMININO(2, "Feminino");
	
	int id;
	String description;
	
	private EnumGender(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	
}
