package br.com.trier.aula_4.diciplinas.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Discipline {

	private int id;
	@NonNull
	private String name;
	@NonNull
	private Integer workload;
	@NonNull
	private Teacher teacher;
	
	
}
