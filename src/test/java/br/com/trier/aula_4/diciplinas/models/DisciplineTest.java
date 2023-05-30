package br.com.trier.aula_4.diciplinas.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;

class DisciplineTest {

	@Test
	@DisplayName("Test constructor and getters")
	void testConstructorAndGetters() {
		Teacher teacher = new Teacher("Joao", EnumEducation.ESPECIALIZATION);
		Discipline discipline = 
				new Discipline("Matemática", 20, teacher);
		assertEquals("Matemática", discipline.getName());
		assertEquals(20, discipline.getWorkload());
		assertEquals(teacher, discipline.getTeacher());
	}
	
	@Test
	@DisplayName("Test setters")
	void testSetters() {
		Teacher teacher = new Teacher("Joao", EnumEducation.ESPECIALIZATION);
		Teacher teacher2 = new Teacher("Maria", EnumEducation.ESPECIALIZATION);
		Discipline discipline = 
				new Discipline("Matemática", 20, teacher);
		discipline.setName("Português");
		discipline.setWorkload(30);
		discipline.setTeacher(teacher2);
		assertEquals("Português", discipline.getName());
		assertEquals(30, discipline.getWorkload());
		assertEquals(teacher2, discipline.getTeacher());
	}

}
