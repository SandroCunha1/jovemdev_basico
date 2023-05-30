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

class StudentTest {
	
	private StudentDao bd = new StudentDao();
	private DisciplineDao diciplineBD = new DisciplineDao();
	private TeacherDao teacherBD = new TeacherDao();
	@BeforeEach
	void init() {
		bd.clearData();
		diciplineBD.clearData();
		teacherBD.clearData();
		Student s1 = new Student("Student 1");
		Student s2 = new Student("Student 2");
		Student s3 = new Student("Student 3");
		Student s4 = new Student("Student 4");
		bd.create(s1);
		bd.create(s2);
		bd.create(s3);
		bd.create(s4);
		
		Teacher t1 = new Teacher("Teacher 1", EnumEducation.ESPECIALIZATION);
		Teacher t2 = new Teacher("Teacher 2", EnumEducation.GRADUATION);
		Teacher t3 = new Teacher("Teacher 3", EnumEducation.P_GRADUATION);
		Teacher t4 = new Teacher("Teacher 4", EnumEducation.GRADUATION);
		teacherBD.create(t1);
		teacherBD.create(t2);
		teacherBD.create(t3);
		teacherBD.create(t4);
		
		Discipline d1 = new Discipline("Mat", 200, t1);
		Discipline d2 = new Discipline("Port", 100, t2);
		Discipline d3 = new Discipline("Geo", 100, t3);
		Discipline d4 = new Discipline("Hist", 100, t4);
		diciplineBD.create(d1);
		diciplineBD.create(d2);
		diciplineBD.create(d3);
		diciplineBD.create(d4);
	}
	
	@Test
	void testAddNewStudentDiscipline() {
		List<Double> notas = new ArrayList<>();
		notas.add(10.0);
		notas.add(9.0);
		notas.add(9.5);
		bd.findById(1).setStudentsDisciplines(diciplineBD.findById(1), notas);
		String diciplineName = bd.findById(1).getStudentsDisciplines().get(0).getDiscipline().getName();
		assertEquals("Mat", diciplineName);
	}
	
	@Test
	void testGettingNotesFromStudentDiscipline() {
		List<Double> notas = new ArrayList<>();
		notas.add(10.0);
		notas.add(9.0);
		notas.add(9.5);
		bd.findById(1).setStudentsDisciplines(diciplineBD.findById(1), notas);
		List<Double> notasAluno = bd.findById(1).getDisciplineNotes(diciplineBD.findById(1));
		assertEquals(notas, notasAluno);
	}
	
	@Test
	void testGettingNotesFromStudentDisciplineNull() {
		List<Double> notas = new ArrayList<>();
		notas.add(10.0);
		notas.add(9.0);
		notas.add(9.5);
		bd.findById(1).setStudentsDisciplines(diciplineBD.findById(1), notas);
		List<Double> notasAluno = bd.findById(1).getDisciplineNotes(diciplineBD.findById(2));
		assertEquals(null, notasAluno);
	}
	
	@Test
	void testGettingDisciplinesAndAverage() {
		List<Double> notas = new ArrayList<>();
		notas.add(10.0);
		notas.add(9.0);
		notas.add(9.5);
		bd.findById(1).setStudentsDisciplines(diciplineBD.findById(1), notas);
		String disciplines = bd.findById(1).getDisciplinesAndAvarege();
		assertEquals("Mat - 9.5", disciplines);
	}

}
