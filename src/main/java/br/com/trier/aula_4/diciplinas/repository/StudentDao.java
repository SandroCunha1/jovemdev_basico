package br.com.trier.aula_4.diciplinas.repository;

import java.util.ArrayList;
import java.util.List;
import br.com.trier.aula_4.diciplinas.models.Student;

public class StudentDao {
	private List<Student> studentsBD = new ArrayList<>();

	public Student create(Student s) {
		s.setId(studentsBD.size() + 1);
		studentsBD.add(s);
		return s;
	}

	public Student findById(final Integer id) {
		return studentsBD.stream()
				.filter(t -> id.equals(t.getId()))
				.findAny()
				.orElse(null);
	}
	
	public Student delete(final Integer id) {
	    Student studentToDelete = findById(id);

	    if (studentToDelete != null) {
	        studentsBD.removeIf(s -> id.equals(s.getId()));
	    }

	    return studentToDelete;
	}

	
	public void clearData() {
		studentsBD.clear();
	}
}
