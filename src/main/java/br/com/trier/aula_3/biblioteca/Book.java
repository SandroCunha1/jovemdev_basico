package br.com.trier.aula_3.biblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Book {

	private String title;
	private double price;
	private List<Author> authors = new ArrayList<Author>();

	public Book(boolean menu, List<Author> allAuthors) {
		int choose = 0;
		boolean cadastroValido = false;

		while (!cadastroValido) {
			try {
				this.title = JOptionPane.showInputDialog("Titulo").toLowerCase();
				if (this.title.trim().equals("")) {
					throw new Exception("Digite um titulo!");
				}
				this.price = Double.parseDouble(JOptionPane.showInputDialog("Preço"));
				if (this.price <= 0) {
					throw new Exception("Preço inválido!");
				}
				do {
					Author author = chooseAuthor(allAuthors);
					if (author == null) {
						continue;
					}
					this.authors.add(author);
					choose = JOptionPane.showConfirmDialog(null, "Deseja adicionar um novo autor ? ");
				} while (this.authors.size() < 4 && choose == 0);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nErro no cadastro!");
				continue;
			}
			cadastroValido = true;
		}
	}

	static Author chooseAuthor(List<Author> authors) {
		String authorName = "";
		try {
			authorName = JOptionPane.showInputDialog("Escolha um autor: \n" + Utils.stringAllArrayObjects(authors));
			if (authorName.trim().equals("")) {
				throw new Exception("Escolha um autor!");
			}
		} catch (Exception e) {
			chooseAuthor(authors);
		}

		for (Author author : authors) {
			if (author.getName().equalsIgnoreCase(authorName)) {
				return author;
			}
		}
		return null;
	}

	public boolean isAuthorInBook(Author author) {
		for (Author ThisAuthor : this.authors) {
			if (author.getName().equalsIgnoreCase(ThisAuthor.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean isInThePrice(double valorMin, double valorMax) {
		if (this.price >= valorMin && this.price <= valorMax) {
			return true;
		}
		return false;
	}

	public boolean isChild() {
		for (Author author : this.authors) {
			if (author.getAge() <= 12) {
				return true;
			}
		}
		return false;
	}

	public boolean isAuthorsGender(EnumGender gender) {
		for (Author author : this.authors) {
			if (!author.getGender().equals(gender)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return this.title + "\nPreço: R$ " + this.price + "\nAutores: \n" + Utils.stringAllArrayObjects(this.authors)
				+ "----------------------------------------------\n";
	}

}
