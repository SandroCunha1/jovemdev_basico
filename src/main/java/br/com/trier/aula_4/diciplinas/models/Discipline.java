package br.com.trier.aula_4.diciplinas.models;

import lombok.Getter;
import lombok.NonNull;


@Getter
public class Discipline {

	private int id;
	@NonNull
	private String name;
	@NonNull
	private Integer workload;
	@NonNull
	private Teacher teacher;

	public void setId(int id) {
		this.id = id;
	}

	public Discipline(@NonNull String name, @NonNull Integer workload, @NonNull Teacher teacher) {
		this.name = name;
		this.workload = workload;
		this.teacher = teacher;
	}
	
	
	
}
