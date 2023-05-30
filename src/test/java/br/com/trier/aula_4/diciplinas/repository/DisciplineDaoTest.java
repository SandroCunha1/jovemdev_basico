package br.com.trier.aula_4.diciplinas.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.models.Discipline;
import br.com.trier.aula_4.diciplinas.models.Student;
import br.com.trier.aula_4.diciplinas.models.Teacher;

class DisciplineDaoTest {

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
	@DisplayName("Teste para verificar a exclusão de uma disciplina existente")
	void testDeleteExistingDiscipline() {
		Discipline deletedDiscipline = diciplineBD.delete(1);

		assertNotNull(deletedDiscipline);
		assertNull(diciplineBD.findById(1));
	}

	@Test
	@DisplayName("Teste para verificar a exclusão de uma disciplina inexistente")
	void testDeleteNonExistingDiscipline() {
		Discipline deletedDiscipline = diciplineBD.delete(10);

		assertNull(deletedDiscipline);
	}

	@Test
	@DisplayName("Teste para verificar se o método 'clearData' limpa corretamente os dados das disciplinas")
	void testClearData() {
		diciplineBD.clearData();

		assertEquals(0, diciplineBD.listForGraduation(EnumEducation.ESPECIALIZATION).size());
		assertEquals(0, diciplineBD.listForGraduation(EnumEducation.GRADUATION).size());
		assertEquals(0, diciplineBD.listForGraduation(EnumEducation.P_GRADUATION).size());

	}

	@Test
	@DisplayName("Teste para adicionar uma nova disciplina")
	void testAddNewDicipline() {
		Discipline created = diciplineBD
				.create(new Discipline("Matemática", 200, new Teacher("Sandro", EnumEducation.P_GRADUATION)));
		assertEquals(created, diciplineBD.findById(5));
	}

	@Test
	@DisplayName("Teste para verificar a listagem de disciplinas por graduação")
	void listForGraduation() {
		assertEquals(1, diciplineBD.listForGraduation(EnumEducation.ESPECIALIZATION).size());
		assertEquals(2, diciplineBD.listForGraduation(EnumEducation.GRADUATION).size());
		assertEquals(1, diciplineBD.listForGraduation(EnumEducation.P_GRADUATION).size());
	}

}
