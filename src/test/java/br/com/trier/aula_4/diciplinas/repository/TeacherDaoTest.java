package br.com.trier.aula_4.diciplinas.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;
import br.com.trier.aula_4.diciplinas.models.Teacher;

class TeacherDaoTest {

	   private TeacherDao teacherDao;

	    @BeforeEach
	    void init() {
	        teacherDao = new TeacherDao();

	        Teacher teacher1 = new Teacher("Teacher 1", EnumEducation.ESPECIALIZATION);
	        Teacher teacher2 = new Teacher("Teacher 2", EnumEducation.ESPECIALIZATION);
	        Teacher teacher3 = new Teacher("Teacher 3", EnumEducation.ESPECIALIZATION);

	        teacherDao.create(teacher1);
	        teacherDao.create(teacher2);
	        teacherDao.create(teacher3);
	    }

	    @Test
	    @DisplayName("Teste para verificar a criação de um professor")
	    void testCreateTeacher() {
	        Teacher newTeacher = new Teacher("Teacher 4", EnumEducation.ESPECIALIZATION);
	        Teacher createdTeacher = teacherDao.create(newTeacher);

	        assertNotNull(createdTeacher);
	        assertNotNull(createdTeacher.getId());
	        assertEquals(newTeacher.getName(), createdTeacher.getName());
	        assertEquals(4, teacherDao.findById(createdTeacher.getId()).getId());
	    }

	    @Test
	    @DisplayName("Teste para encontrar um professor existente pelo ID")
	    void testFindById() {
	        Teacher teacher = teacherDao.findById(2);

	        assertNotNull(teacher);
	        assertEquals(2, teacher.getId());
	        assertEquals("Teacher 2", teacher.getName());
	    }

	    @Test
	    @DisplayName("Teste para encontrar um professor inexistente pelo ID")
	    void testFindNonExistingTeacherById() {
	        Teacher teacher = teacherDao.findById(5);

	        assertNull(teacher);
	    }

	    @Test
	    @DisplayName("Teste para excluir um professor existente pelo ID")
	    void testDeleteExistingTeacher() {
	        Teacher deletedTeacher = teacherDao.delete(1);

	        assertNotNull(deletedTeacher);
	        assertEquals(1, deletedTeacher.getId());
	        assertNull(teacherDao.findById(1));
	    }

	    @Test
	    @DisplayName("Teste para excluir um professor inexistente pelo ID")
	    void testDeleteNonExistingTeacher() {
	        Teacher deletedTeacher = teacherDao.delete(5);

	        assertNull(deletedTeacher);
	    }

	    @Test
	    @DisplayName("Teste para limpar os dados dos professores")
	    void testClearData() {
	        teacherDao.clearData();

	        assertEquals(0, teacherDao.findAll().size());
	    }

}
