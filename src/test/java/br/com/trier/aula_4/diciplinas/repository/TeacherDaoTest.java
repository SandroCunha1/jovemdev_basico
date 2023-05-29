package br.com.trier.aula_4.diciplinas.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.models.Teacher;

class TeacherDaoTest {

	private TeacherDao bd = new TeacherDao();
	
	@Test
	void testAddNewTeacher() {
		Teacher created = bd.create(new Teacher("Sandro", EnumEducation.ESPECIALIZATION));
		assertEquals(created, bd.findById(1));
	}

}
