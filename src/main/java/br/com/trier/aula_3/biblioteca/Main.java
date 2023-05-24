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
			} else if (op == 2) {
				
			} else if (op == 3) {
				
			} else if (op == 4) {
				
			} else if (op == 5) {
				
			} else if (op == 6) {
				
			}
		} while (op != 7);
	}
}
