package br.com.trier.aula_3.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UtilsTest {

	@Test
	void passandroStringDeLivrosERetornandoCorretamente() {
		List<Author> authors = new ArrayList<Author>();
		Book livro = new Book("The book", 20.0, authors);
		Book livro2 = new Book("The book", 20.0, authors);
		List<Book> livros = new ArrayList<Book>();
		livros.add(livro);
		livros.add(livro2);
		
		assertEquals("*"+livro.getTitle() + "*\nPreço: R$ " + livro.getPrice() + "\nAutores: \n" + Utils.stringAllArrayObjects(livro.getAuthors())
				+ "----------------------------------------------\n" + "*"+livro2.getTitle() + "*\nPreço: R$ " + livro2.getPrice() + "\nAutores: \n" + Utils.stringAllArrayObjects(livro2.getAuthors())
				+ "----------------------------------------------\n", Utils.stringAllArrayObjects(livros));
	}
	
	@Test
	void passandroStringDeAutoresERetornandoCorretamente() {
		Author autor = new Author("Marcos", EnumGender.FEMININO, 20);
		Author autor2 = new Author("Marcos", EnumGender.FEMININO, 20);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		authors.add(autor2);
		
		assertEquals("   ["+autor.getName() + "]\n    Idade: " + autor.getAge() + "\n    Sexo: " + autor.getGender().getDescription() + "\n"
		+"   ["+autor2.getName() + "]\n    Idade: " + autor2.getAge() + "\n    Sexo: " + autor2.getGender().getDescription() + "\n", Utils.stringAllArrayObjects(authors));
	}
	
	

}
