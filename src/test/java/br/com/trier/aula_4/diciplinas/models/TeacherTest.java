package br.com.trier.aula_4.diciplinas.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;

class TeacherTest {

	@Test
	void testConstructorAndGetters() {
		Teacher teacher = new Teacher("Joao", EnumEducation.ESPECIALIZATION);
		assertEquals("Joao", teacher.getName());
		assertEquals(EnumEducation.ESPECIALIZATION, teacher.getEducation());
	}
	
	@Test
	void testSetters() {
		Teacher teacher = new Teacher("Joao", EnumEducation.ESPECIALIZATION);
		teacher.setName("Maria");
		teacher.setEducation(EnumEducation.GRADUATION);
		assertEquals("Maria", teacher.getName());
		assertEquals(EnumEducation.GRADUATION, teacher.getEducation());
	}

}
