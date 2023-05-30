package br.com.trier.aula_4.diciplinas.models;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentDiscipline {

	private Student student;
	private Discipline discipline;
	private List<Double> notes = new ArrayList<>();
	
	
	public Double getAverage() {
		return notes
				.stream()
				.mapToDouble(n -> n)
				.average()
				.orElse(0.0);
	}
}
