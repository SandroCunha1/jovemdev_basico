package br.com.trier.aula_3.biblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		List<Author> authors = new ArrayList<Author>();
		List<Book> books = new ArrayList<Book>();
		int op = 0;

		do {
			try {
				op = Utils.escolheOp();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "DIGITE UM NÚMERO!");
				continue;
			}

			if (op == 1) {
				Author author = new Author();
				author.cadastraAutor();
				authors.add(author);
			} else if (op == 2) {
				Book book = new Book();
				book.cadastraBook(authors);
				books.add(book);
			} else if (op == 3) {
				JOptionPane.showMessageDialog(null, Utils.stringAllArrayObjects(books));	
			} else if (op == 4) {
				JOptionPane.showMessageDialog(null, Utils.stringAllArrayObjects(Utils.getBooksForAuthors(authors, books)));
			} else if (op == 5) {
				JOptionPane.showMessageDialog(null, Utils.stringAllArrayObjects(Utils.getBooksByPrice(books)));
			} else if (op == 6) {
				JOptionPane.showMessageDialog(null, Utils.stringAllArrayObjects(Utils.getBooksWithChildAuthors(books)));
			} else if (op == 7) {
				JOptionPane.showMessageDialog(null, Utils.stringAllArrayObjects(Utils.getBooksByGender(books)));
			}
		} while (op != 8);
	}
}
