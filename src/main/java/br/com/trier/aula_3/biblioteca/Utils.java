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

	static Author chooseAuthor(List<Author> authors) {
		String authorName = "";
		try {
			authorName = JOptionPane.showInputDialog("Escolha um autor: \n" + Utils.stringAllArrayObjects(authors));
			if (authorName.trim().equals("")) {
				throw new Exception("Escolha um autor!");
			}
		} catch (Exception e) {
			if (JOptionPane.showConfirmDialog(null, "Você deseja sair?") < 1) {
				return null;
			}
			chooseAuthor(authors);
		}

		for (Author author : authors) {
			if (author.getName().equalsIgnoreCase(authorName)) {
				return author;
			}
		}
		return null;
	}

	static <T> String stringAllArrayObjects(List<T> Array) {
		String ret = "";
		for (T object : Array) {
			ret += object.toString();
		}

		return ret;
	}

	static List<Book> getBooksForAuthors(List<Author> authors, List<Book> books) {
		List<Book> authorBooks = new ArrayList<>();

		Author author = chooseAuthor(authors);
		if (author == null) {
			JOptionPane.showMessageDialog(null, "Você precisa escolher um autor !");
			getBooksForAuthors(authors, books);
		}

		for (Book book : books) {
			if (book.isAuthorInBook(author)) {
				authorBooks.add(book);
			}
		}
		return authorBooks;
	}

	static List<Book> getBooksByPrice(List<Book> books) {
		List<Book> booksInThePrice = new ArrayList<>();
		double valorMin = 0;
		double valorMax = 0;
		try {
			valorMin = Double.parseDouble(JOptionPane.showInputDialog("Valor minimo:"));
			if (valorMin < 0) {
				throw new Exception();
			}
			valorMax = Double.parseDouble(JOptionPane.showInputDialog("Valor máximo:"));
		} catch (Exception e) {
			getBooksByPrice(books);
		}

		for (Book book : books) {
			if (book.isInThePrice(valorMin, valorMax)) {
				booksInThePrice.add(book);
			}
		}
		return booksInThePrice;
	}

	static List<Book> getBooksWithChildAuthors(List<Book> books) {
		List<Book> booksWithChild = new ArrayList<>();
		for (Book book : books) {
			if (book.isChild()) {
				booksWithChild.add(book);
			}
		}
		return booksWithChild;
	}

	static List<Book> getBooksByGender(List<Book> books) {
		List<Book> booksGender = new ArrayList<>();
		EnumGender gender = EnumGender.escolheGenero();
		for (Book book : books) {
			if (book.isAuthorsGender(gender)) {
				booksGender.add(book);
			}
		}
		return booksGender;
	}

}
