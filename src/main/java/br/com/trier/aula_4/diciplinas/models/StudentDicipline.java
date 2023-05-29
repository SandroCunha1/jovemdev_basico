package br.com.trier.aula_4.diciplinas.models;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentDicipline {

	private Student student;
	private Dicipline dicipline;
	private List<Double> notes = new ArrayList<>();
}
