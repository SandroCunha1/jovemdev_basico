package br.com.trier.aula_3.biblioteca;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
	private String name;
	private EnumGender gender;
	private int age;

	public Author() {	
	}
	public void cadastraAutor() {
		boolean cadastroValido = false;

		while (!cadastroValido) {
			try {
				setName();
				setAge();
				setGender();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nErro no cadastro!");
				continue;
			}
			cadastroValido = true;
		}
	}

	public void setName() throws Exception {
		this.name = JOptionPane.showInputDialog("Nome e Sobrenome");
		String[] palavras = this.name.split(" ");
		int quantidadePalavras = palavras.length;
		System.err.println(quantidadePalavras);
		if (this.name.trim().equals("") || quantidadePalavras < 2) {
			throw new Exception("Digite o nome e sobrenome!");
		}
	}

	public void setAge() throws Exception {
		this.age = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
		if (this.age <= 0) {
			throw new Exception("Idade inválida!");
		}
	}

	public void setGender() throws Exception {
		this.gender = EnumGender.escolheGenero();
	}

	@Override
	public String toString() {
		return this.name + "\n Idade: " + this.age + "\n Sexo: " + gender.getDescription() + "\n\n";
	}
}
