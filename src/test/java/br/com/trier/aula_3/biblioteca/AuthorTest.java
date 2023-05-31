package br.com.trier.aula_3.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AuthorTest {


    @Test
    @DisplayName("Teste setName() com nome válido")
    void testSetNameWithValidName() {
        Author author = new Author();

        assertDoesNotThrow(() -> {
        	author.setName("John Doe");
        });
    }

    @Test
    @DisplayName("Teste setName() com nome vazio")
    void testSetNameWithEmptyName() {
    	Author author = new Author();

        Exception exception = assertThrows(Exception.class, () -> {
        	author.setName("");
        });

        String expectedMessage = "Digite o nome e sobrenome!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Teste setName() com nome com apenas uma palavra")
    void testSetNameWithSingleWordName() {
    	Author author = new Author();

        Exception exception = assertThrows(Exception.class, () -> {
        	author.setName("John");
        });

        String expectedMessage = "Digite o nome e sobrenome!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    @DisplayName("Teste setAge() com idade válida")
    void testSetAgeWithValidAge() {
        Author author = new Author();

        assertDoesNotThrow(() -> {
            author.setAge(30);
        });
    }

    @Test
    @DisplayName("Teste setAge() com idade inválida")
    void testSetAgeWithInvalidAge() {
        Author author = new Author();

        Exception exception = assertThrows(Exception.class, () -> {
            author.setAge(0);
        });

        String expectedMessage = "Idade inválida!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Teste setGender() com gênero válido")
    void testSetGenderWithValidGender() {
        Author author = new Author();

        assertDoesNotThrow(() -> {
            author.setGender(EnumGender.MASCULINO);
        });
    }

	/*
	 * @Test
	 * 
	 * @DisplayName("Teste setGender() com gênero inválido") void
	 * testSetGenderWithInvalidGender() { Author author = new Author();
	 * 
	 * Exception exception = assertThrows(Exception.class, () -> {
	 * author.setGender(null); });
	 * 
	 * String expectedMessage = "Gênero inválido!"; String actualMessage =
	 * exception.getMessage();
	 * 
	 * assertEquals(expectedMessage, actualMessage); }
	 */

}
