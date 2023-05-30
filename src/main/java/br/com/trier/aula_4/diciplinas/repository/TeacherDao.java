package br.com.trier.aula_4.diciplinas.repository;

import java.util.ArrayList;
import java.util.List;
import br.com.trier.aula_4.diciplinas.models.Teacher;

public class TeacherDao {

	private List<Teacher> teachersBD = new ArrayList<>();
	
	public Teacher create(Teacher t) {
		t.setId(teachersBD.size()+1);
		teachersBD.add(t);
		return t;
	}
	
	public Teacher findById (final Integer id) {
		return teachersBD.stream()
				.filter(t -> id.equals(t.getId()))
				.findAny()
				.orElse(null);
	}
	
	public Teacher delete(final Integer id) {
	    Teacher teacherToDelete = findById(id);

	    if (teacherToDelete != null) {
	        teachersBD.removeIf(t -> id.equals(t.getId()));
	    }

	    return teacherToDelete;
	}

	
	public void clearData() {
		teachersBD.clear();
	}

	public List<Teacher> findAll() {
		return teachersBD;
	}
}
