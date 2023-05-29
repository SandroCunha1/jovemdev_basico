package br.com.trier.aula_4.diciplinas.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EnumEducation {

	GRADUATION(1, "Graduação"),
	ESPECIALIZATION(2, "Epecialização"),
	P_GRADUATION(3, "Pós-Graduação");
	
	private int id;
	private String description;

}
