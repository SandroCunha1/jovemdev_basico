package br.com.trier.aula_3.biblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Utils {

	static int escolheOp() {
		String menu = "1 - Cadastrar Autor\n" + "2 - Cadastrar Livros\n" + "3 - Listar todos os livros cadastrados\n"
				+ "4 - Pesquisar por autor\n" + "5 - Pesquisar por faixa de valor do livro\n"
				+ "6 - Listar todos os livros cujo autores tenham crianças\n"
				+ "7 – Listar todos os livros que foram escritos apenas por mulheres ou por homens\n\n" + "8 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	static <T> String stringAllArrayObjects(List<T> Array) {
		String ret = "";
		for (T object : Array) {
			ret += object.toString();
		}

		return ret;
	}

	static String getBooksForAuthors(List<Author> authors, List<Book> books) {
		List<Book> authorBooks = new ArrayList<>();
		Author author = Book.chooseAuthor(authors);
		for (Book book : books) {
			if (book.isAuthorInBook(author)) {
				authorBooks.add(book);
			}
		}
		return stringAllArrayObjects(authorBooks);
	}

	static String getBooksByPrice(List<Book> books) {
		List<Book> booksInThePrice = new ArrayList<>();
		double valorMin = Double.parseDouble(JOptionPane.showInputDialog("Valor minimo:"));
		double valorMax = Double.parseDouble(JOptionPane.showInputDialog("Valor máximo:"));
		for (Book book : books) {
			if (book.isInThePrice(valorMin, valorMax)) {
				booksInThePrice.add(book);
			}
		}
		return stringAllArrayObjects(booksInThePrice);
	}

	static String getBooksWithChildAuthors(List<Book> books) {
		List<Book> booksWithChild = new ArrayList<>();
		for (Book book : books) {
			if (book.isChild()) {
				booksWithChild.add(book);
			}
		}
		return stringAllArrayObjects(booksWithChild);
	}

	static String getBooksByGender(List<Book> books) {
		List<Book> booksGender = new ArrayList<>();
		EnumGender gender = EnumGender.escolheGenero();
		for (Book book : books) {
			if (book.isAuthorsGender(gender)) {
				booksGender.add(book);
			}
		}
		return stringAllArrayObjects(booksGender);
	}

}
