package br.com.trier.aula_4.medicamentos.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumUses {
	INJECTABLE(1, "Injetável"),
	TOPICAL(2, "Tópico"),
	ORAL(3, "Oral"),
	SUPPOSITORY(4, "Sopositório");
	
	private int id;
	private String description;
}
