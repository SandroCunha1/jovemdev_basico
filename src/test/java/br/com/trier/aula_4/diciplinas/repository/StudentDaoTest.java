package br.com.trier.aula_4.diciplinas.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.models.Dicipline;
import br.com.trier.aula_4.diciplinas.models.Student;
import br.com.trier.aula_4.diciplinas.models.Teacher;


class StudentDaoTest {

	private StudentDao bd = new StudentDao();
	private DiciplineDao diciplineBD = new DiciplineDao();
	private TeacherDao teacherBD = new TeacherDao();
	@BeforeEach
	void init() {
		bd.clearData();
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
		
		Dicipline d1 = new Dicipline("Mat", t1);
		Dicipline d2 = new Dicipline("Port", t2);
		Dicipline d3 = new Dicipline("Geo", t3);
		Dicipline d4 = new Dicipline("Hist", t4);
		diciplineBD.create(d1);
		diciplineBD.create(d2);
		diciplineBD.create(d3);
		diciplineBD.create(d4);
	}
	
	@Test
	void testAddNewStudent() {
		Student created = bd.create(new Student("Sandro"));
		assertEquals(created, bd.findById(1));
	}
	
	@Test
	void testAddNewStudentDicipline() {
		bd.findById(1).setStudentsDiciplines(null, null);
		//assertEquals(created, bd.findById(1));
	}

}
