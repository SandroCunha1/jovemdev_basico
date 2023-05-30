package br.com.trier.aula_4.diciplinas.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.repository.TeacherDao;

class TeacherTest {

	private TeacherDao teacherBD = new TeacherDao();
	@BeforeEach
	void init() {
		teacherBD.clearData();
		Teacher t1 = new Teacher("Teacher 1", EnumEducation.ESPECIALIZATION);
		teacherBD.create(t1);

	}
	
	
	@Test
	@DisplayName("Teste do construtor")
	void testConstructor() {
		assertNotNull(teacherBD.findById(1));
		assertEquals("Teacher 1", teacherBD.findById(1).getName());
		
	}

	@Test
	@DisplayName("Teste do nome vazio")
	void testConstructorNameNull() {
		assertThrows(Exception.class, () -> {
			@SuppressWarnings("unused")
			Teacher teacher = new Teacher(null , EnumEducation.ESPECIALIZATION);
		});
	}
	
	@Test
	@DisplayName("Teste da graduação vazia")
	void testConstructorEducationNull() {
		assertThrows(Exception.class, () -> {
			@SuppressWarnings("unused")
			Teacher teacher = new Teacher("Teacher" , null);
		});
	}

}
