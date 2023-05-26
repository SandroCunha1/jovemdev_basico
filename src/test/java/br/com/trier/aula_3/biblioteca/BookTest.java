package br.com.trier.aula_3.biblioteca;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookTest {

	

	@Test
	void autorEstaNoLivroDeveRetornarTrue() {
		Author autor = new Author("Marcos", EnumGender.MASCULINO, 20);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		Book livro = new Book("The book", 20.0, authors);

		assertTrue(livro.isAuthorInBook(autor));
	}

	@Test
	void autorNaoEstaNoLivroDeveRetornarFalse() {
		Author autor = new Author("Marcos", EnumGender.MASCULINO, 20);
		List<Author> authors = new ArrayList<Author>();
		Book livro = new Book("The book", 20.0, authors);

		assertFalse(livro.isAuthorInBook(autor));
	}

	@Test
	void livroEstaDentroDaFachaDePrecoDeveRetornarTrue() {
		List<Author> authors = new ArrayList<Author>();
		Book livro = new Book("The book", 20.0, authors);

		assertTrue(livro.isInThePrice(0, 20));
	}

	@Test
	void livroEstaForaDaFachaDePrecoDeveRetornarFalse() {
		List<Author> authors = new ArrayList<Author>();
		Book livro = new Book("The book", 20.0, authors);

		assertFalse(livro.isInThePrice(0, 10));
	}
	
	@Test
	void livroFeitoPorUmaCriancaDePrecoDeveRetornarTrue() {
		Author autor = new Author("Marcos", EnumGender.MASCULINO, 10);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		Book livro = new Book("The book", 20.0, authors);

		assertTrue(livro.isChild());
	}
	
	@Test
	void livroFeitoPorUmAdultoDePrecoDeveRetornarFalse() {
		Author autor = new Author("Marcos", EnumGender.MASCULINO, 20);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		Book livro = new Book("The book", 20.0, authors);

		assertFalse(livro.isChild());
	}
	
	@Test
	void livroFeitoPorHomensDeveRetornarTrue() {
		Author autor = new Author("Marcos", EnumGender.MASCULINO, 20);
		Author autor2 = new Author("Marcos", EnumGender.MASCULINO, 20);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		authors.add(autor2);
		Book livro = new Book("The book", 20.0, authors);

		assertTrue(livro.isAuthorsGender(EnumGender.MASCULINO));
	}
	
	@Test
	void livroFeitoPorHomensDeveRetornarFalse() {
		Author autor = new Author("Marcos", EnumGender.MASCULINO, 20);
		Author autor2 = new Author("Marcos", EnumGender.MASCULINO, 20);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		authors.add(autor2);
		Book livro = new Book("The book", 20.0, authors);

		assertFalse(livro.isAuthorsGender(EnumGender.FEMININO));
	}
	
	@Test
	void livroFeitoPorMulheresDeveRetornarTrue() {
		Author autor = new Author("Marcos", EnumGender.FEMININO, 20);
		Author autor2 = new Author("Marcos", EnumGender.FEMININO, 20);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		authors.add(autor2);
		Book livro = new Book("The book", 20.0, authors);

		assertTrue(livro.isAuthorsGender(EnumGender.FEMININO));
	}
	
	@Test
	void livroFeitoPorMulheresDeveRetornarFalse() {
		Author autor = new Author("Marcos", EnumGender.FEMININO, 20);
		Author autor2 = new Author("Marcos", EnumGender.FEMININO, 20);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		authors.add(autor2);
		Book livro = new Book("The book", 20.0, authors);

		assertFalse(livro.isAuthorsGender(EnumGender.MASCULINO));
	}
	
	@Test
	void livroFeitoPorHomensEMulheresDeveRetornarFalse() {
		Author autor = new Author("Marcos", EnumGender.MASCULINO, 20);
		Author autor2 = new Author("Marcos", EnumGender.FEMININO, 20);
		List<Author> authors = new ArrayList<Author>();
		authors.add(autor);
		authors.add(autor2);
		Book livro = new Book("The book", 20.0, authors);

		assertFalse(livro.isAuthorsGender(EnumGender.MASCULINO));
	}
	
	

}
