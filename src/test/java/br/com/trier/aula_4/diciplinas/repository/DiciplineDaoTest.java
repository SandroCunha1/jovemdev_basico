package br.com.trier.aula_4.diciplinas.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.models.Dicipline;
import br.com.trier.aula_4.diciplinas.models.Student;
import br.com.trier.aula_4.diciplinas.models.Teacher;

class DiciplineDaoTest {

	private DiciplineDao bd = new DiciplineDao();
	@Test
	void testAddNewDicipline() {
		Dicipline created = bd.create(new Dicipline("Matemática", new Teacher("Sandro", EnumEducation.P_GRADUATION)));
		assertEquals(created, bd.findById(1));
	}

}
