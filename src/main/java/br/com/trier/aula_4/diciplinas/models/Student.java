package br.com.trier.aula_4.diciplinas.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Student {
	private int id;
	@NonNull
	private String name;
	@NonNull
	private List<StudentDicipline> studentsDiciplines = new ArrayList<>();
	
	
	
	public void setStudentsDiciplines(Dicipline dicipline, List<Double> notes) {
		studentsDiciplines.add(new StudentDicipline(this, dicipline, notes));
	}
}
