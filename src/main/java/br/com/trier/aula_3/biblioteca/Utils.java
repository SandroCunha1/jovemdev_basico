package br.com.trier.aula_3.biblioteca;

import javax.swing.JOptionPane;

public class Utils {

	static int escolheOp() {
		String menu = "1 - Cadastrar Autor\n" 
				+ "2 - Cadastrar Livros\n"
				+ "3 - Listar todos os livros cadastrados\n" 
				+ "4 - Pesquisar por autor\n" 
				+ "5 - Pesquisar por faixa de valor do livro\n"
				+ "6 - Listar todos os livros cujo autores tenham crianças\n\n"
				+ "7 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
}
