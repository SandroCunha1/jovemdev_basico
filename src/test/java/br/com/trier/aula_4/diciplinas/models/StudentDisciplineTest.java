package br.com.trier.aula_4.diciplinas.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.repository.DisciplineDao;
import br.com.trier.aula_4.diciplinas.repository.StudentDao;
import br.com.trier.aula_4.diciplinas.repository.TeacherDao;

class StudentDisciplineTest {

	private StudentDao bd = new StudentDao();
	private DisciplineDao diciplineBD = new DisciplineDao();
	private TeacherDao teacherBD = new TeacherDao();
	@BeforeEach
	void init() {
		bd.clearData();
		Student s1 = new Student("Student 1");
		bd.create(s1);
		Teacher t1 = new Teacher("Teacher 1", EnumEducation.ESPECIALIZATION);
		teacherBD.create(t1);
		Discipline d1 = new Discipline("Mat", 200, t1);
		diciplineBD.create(d1);
	}
	@Test
	void testCalcAverage() {
		List<Double> notas = new ArrayList<>();
		notas.add(10.0);
		notas.add(9.0);
		notas.add(9.5);
		bd.findById(1).setStudentsDisciplines(diciplineBD.findById(1), notas);
		Double media = bd.findById(1).getStudentsDisciplines().get(0).getAverage();
		assertEquals(9.5, media);
	}

}
