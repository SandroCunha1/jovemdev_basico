package br.com.trier.aula_4.diciplinas.models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.repository.DisciplineDao;
import br.com.trier.aula_4.diciplinas.repository.StudentDao;
import br.com.trier.aula_4.diciplinas.repository.TeacherDao;

class StudentDisciplineTest {

	private StudentDao bd = new StudentDao();
	private DisciplineDao diciplineBD = new DisciplineDao();
	private TeacherDao teacherBD = new TeacherDao();
	private StudentDiscipline studentD;
	private List<Double> notas;
	@BeforeEach
	void init() {
		notas = new ArrayList<>();
		notas.add(10.0);
		notas.add(9.0);
		notas.add(9.5);
		bd.clearData();
		diciplineBD.clearData();
		teacherBD.clearData();
		Student s1 = new Student("Student 1");
		bd.create(s1);
		Teacher t1 = new Teacher("Teacher 1", EnumEducation.ESPECIALIZATION);
		teacherBD.create(t1);
		Discipline d1 = new Discipline("Mat", 200, t1);
		diciplineBD.create(d1);
		studentD = new StudentDiscipline(s1, d1, notas);
	}
	
	@Test
    @DisplayName("Teste do construtor")
    void testConstructor() {
        assertNotNull(studentD);
        assertEquals(bd.findById(1), studentD.getStudent());
        assertEquals(diciplineBD.findById(1), studentD.getDiscipline());
        assertEquals(notas, studentD.getNotes());
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
