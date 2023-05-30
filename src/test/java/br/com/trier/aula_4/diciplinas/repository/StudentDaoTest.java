package br.com.trier.aula_4.diciplinas.repository;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.models.Discipline;
import br.com.trier.aula_4.diciplinas.models.Student;
import br.com.trier.aula_4.diciplinas.models.Teacher;


class StudentDaoTest {

	private StudentDao bd = new StudentDao();
	private DisciplineDao diciplineBD = new DisciplineDao();
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
	void testAddNewStudent() {
		Student created = bd.create(new Student("Sandro"));
		assertEquals(created, bd.findById(5));
	}
	
	@Test
    void testDeleteLast() {
		Student student = new Student("Marquinhos");
        bd.create(student);

        assertNotNull(bd.findById(5));

        Student deletedStudent = bd.delete(5);

        assertEquals(student, deletedStudent);
        assertNull(bd.findById(5));
    }
	
	@Test
    void testDeleteFirst() {
        assertNotNull(bd.findById(1));
        bd.delete(1);
        assertNull(bd.findById(1));
    }
	
	

}
