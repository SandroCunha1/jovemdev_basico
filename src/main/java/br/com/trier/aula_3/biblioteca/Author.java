package br.com.trier.aula_3.biblioteca;

import javax.swing.JOptionPane;

public class Author {
	private String name;
	private EnumGender gender;
	private int age;

	public Author(boolean menu) {
		boolean cadastroValido = false;

		while (!cadastroValido) {
			try {
				this.name = JOptionPane.showInputDialog("Nome");
				if (this.name.trim().equals("")) {
					throw new Exception("Digite um nome!");
				}

				this.age = Integer.parseInt(JOptionPane.showInputDialog("Idade"));

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nErro no cadastro!");
				continue;
			}
			cadastroValido = true;
		}
	}
}
