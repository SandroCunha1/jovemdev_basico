package br.com.trier.aula_4.diciplinas.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.trier.aula_4.diciplinas.models.Dicipline;

public class DiciplineDao {

	private List<Dicipline> diciplineBD = new ArrayList<>();
	
	public Dicipline create(Dicipline s) {
		s.setId(diciplineBD.size() + 1);
		diciplineBD.add(s);
		return s;
	}

	public Dicipline findById(final Integer id) {
		return diciplineBD.stream()
				.filter(t -> id.equals(t.getId()))
				.findAny()
				.orElse(null);
	}
	
	public void clearData() {
		diciplineBD.clear();
	}
}
