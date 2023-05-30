package br.com.trier.aula_4.diciplinas.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Student {
	private int id;
	@NonNull
	private String name;
	private List<StudentDiscipline> studentsDisciplines = new ArrayList<>();

	
	public void setStudentsDisciplines(Discipline discipline, List<Double> notes) {
		studentsDisciplines.add(new StudentDiscipline(this, discipline, notes));
	}

	public List<Double> getDisciplineNotes(Discipline discipline) {
		StudentDiscipline d = studentsDisciplines
								.stream()
								.filter(s -> s.getDiscipline().equals(discipline)).findAny()
								.orElse(null);
		if (d != null)
			return d.getNotes();
		else
			return null;
	}

	public String getDisciplinesAndAvarege() {

		String result = studentsDisciplines
				.stream()
				.map(sd -> sd.getDiscipline().getName() + " - " + sd.getAverage())
				.collect(Collectors.joining("\n"));

		return result;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	


	
	
}
