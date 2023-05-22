package br.com.trier.aula_1;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Cliente {

	public static void main(String[] args) {
		boolean addPessoa = true;
		boolean validaSexo = true;
		String nome;
		char sexo;
		double peso;
		double altura;

		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (addPessoa) {

			int newPessoa = JOptionPane.showConfirmDialog(null, "Você deseja adicionar uma nova pessoa ?");

			if (newPessoa < 1) {
				
				nome = JOptionPane.showInputDialog("Nome:");
				do {
					sexo = JOptionPane.showInputDialog("Sexo (M) ou (F):").toUpperCase().charAt(0);
					System.out.println(sexo);
				} while (sexo != 'M' && sexo != 'F');
				peso = Double.parseDouble(JOptionPane.showInputDialog("Peso (em kg):"));
				altura = Double.parseDouble(JOptionPane.showInputDialog("Altura (em metros):"));

				pessoas.add(new Pessoa(nome, sexo, peso, altura));

			} else {
				StringBuilder msg = new StringBuilder();

				for (int i = 0; i < pessoas.size(); i++) {
					msg.append(String.format("Nome: %s", pessoas.get(i).getNome()));
					msg.append(String.format("%nIMC: %.2f", pessoas.get(i).getIMC()));
					msg.append(String.format("%nAvaliação IMC: %s \n\n", pessoas.get(i).getAvaliacaoIMC()));
				}

				JOptionPane.showMessageDialog(null, msg);
				addPessoa = false;
			}

		}

	}
}
