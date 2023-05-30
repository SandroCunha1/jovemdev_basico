package br.com.trier.aula_4.diciplinas.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.models.Discipline;

public class DisciplineDao {

	private List<Discipline> diciplineBD = new ArrayList<>();
	
	public Discipline create(Discipline s) {
		s.setId(diciplineBD.size() + 1);
		diciplineBD.add(s);
		return s;
	}

	public Discipline findById(final Integer id) {
		return diciplineBD.stream()
				.filter(t -> id.equals(t.getId()))
				.findAny()
				.orElse(null);
	}
	
	public Discipline delete(final Integer id) {
		Discipline disciplineToDelete = findById(id);

		if (disciplineToDelete != null) {
			diciplineBD.removeIf(d -> id.equals(d.getId()));
		}

		return disciplineToDelete;
	}

	public void clearData() {
		diciplineBD.clear();
	}
	
	public List<Discipline> listForGraduation(EnumEducation graduation) {
		List<Discipline>  filtered = diciplineBD
										.stream()
										.filter(d -> d.getTeacher().getEducation() == graduation)
										.toList();
		return filtered;
		                   
	}
}
