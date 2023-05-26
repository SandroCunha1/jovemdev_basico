package br.com.trier.aula_3.biblioteca;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Book {

	private String title;
	private double price;
	private List<Author> authors = new ArrayList<Author>();

	public Book() {	
	}
	
	public void cadastraBook(List<Author> allAuthors) {
		boolean cadastroValido = false;

		while (!cadastroValido) {
			try {
				setTitulo();
				setPrice();
				setAuthors(allAuthors);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nErro no cadastro!");
				continue;
			}
			cadastroValido = true;
		}
	}

	public void setTitulo() throws Exception {
		this.title = JOptionPane.showInputDialog("Titulo").toLowerCase();
		if (this.title.trim().equals("")) {
			throw new Exception("Digite um titulo!");
		}
	}

	public void setPrice() throws Exception {
		this.price = Double.parseDouble(JOptionPane.showInputDialog("Preço"));
		if (this.price <= 0) {
			throw new Exception("Preço inválido!");
		}
	}
	
	public void setAuthors(List<Author> allAuthors) throws Exception {
		int choose = 0;
		do {
			Author author = Utils.chooseAuthor(allAuthors);
			if (author == null) {
				break;
			}
			if (isAuthorInBook(author)) {
				JOptionPane.showMessageDialog(null, "Já é um autor deste livro!");
				continue;
			}
			this.authors.add(author);
			choose = JOptionPane.showConfirmDialog(null, "Deseja adicionar um novo autor ? ");
		} while (this.authors.size() < 4 && choose == 0);
	}
	

	public boolean isAuthorInBook(Author author) {
		for (Author ThisAuthor : this.authors) {
			if (ThisAuthor.equals(author)) {
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
		return "*"+this.title + "*\nPreço: R$ " + this.price + "\nAutores: \n" + Utils.stringAllArrayObjects(this.authors)
				+ "----------------------------------------------\n";
	}

}
