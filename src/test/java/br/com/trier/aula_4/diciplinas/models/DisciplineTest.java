package br.com.trier.aula_4.diciplinas.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.enums.EnumEducation;

class DisciplineTest {
	    private Discipline discipline;
	    private Teacher teacher;

	    @BeforeEach
	    void init() {
	        teacher = new Teacher("John Doe", EnumEducation.ESPECIALIZATION);
	        discipline = new Discipline("Math", 60, teacher);
	        
	        
	    }

	    @Test
	    @DisplayName("Teste do construtor")
	    void testConstructor() {
	        assertNotNull(discipline);
	        assertEquals("Math", discipline.getName());
	        assertEquals(60, discipline.getWorkload());
	        assertEquals(teacher, discipline.getTeacher());
	    }
	    
	    @Test
	    @DisplayName("Teste do nome vazio") 
	    void testConstructorNameNull() {
	    	assertThrows(Exception.class ,() -> {
	    		@SuppressWarnings("unused")
				Discipline discipline2 = new Discipline(null, 30, teacher);
	        	}); 
	    }
	    
	    @Test
	    @DisplayName("Teste da carga horaria vazia") 
	    void testConstructorWorkloadNull() {
	    	assertThrows(Exception.class ,() -> {
	    		@SuppressWarnings("unused")
				Discipline discipline2 = new Discipline("Math", null, teacher);
	        	}); 
	    }
	    
	    @Test
	    @DisplayName("Teste do professir vazio") 
	    void testConstructorTeacherNull() {
	    	assertThrows(Exception.class ,() -> {
	    		@SuppressWarnings("unused")
				Discipline discipline2 = new Discipline("Math", 20, null);
	        	}); 
	    }
	    
	    @Test
	    @DisplayName("Teste do construtor vazio") 
	    void testConstructorNull() {
	    	assertThrows(Exception.class ,() -> {
	    		@SuppressWarnings("unused")
				Discipline discipline2 = new Discipline(null, null, null);
	        	}); 
	    }

	    @Test
	    @DisplayName("Teste do getter para o atributo name")
	    void testGetName() {
	        assertEquals("Math", discipline.getName());
	    }

	    @Test
	    @DisplayName("Teste do getter para o atributo workload")
	    void testGetWorkload() {
	        assertEquals(60, discipline.getWorkload());
	    }

	    @Test
	    @DisplayName("Teste do getter para o atributo teacher")
	    void testGetTeacher() {
	        assertEquals(teacher, discipline.getTeacher());
	    }

	    @Test
	    @DisplayName("Teste do setter para o atributo id")
	    void testSetId() {
	        discipline.setId(1);
	        assertEquals(1, discipline.getId());
	    }
	}

