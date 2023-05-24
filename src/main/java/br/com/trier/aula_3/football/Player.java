package br.com.trier.aula_3.football;

import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

	private String name;
	private int shirtNumber;
	private int gols;

	public Player(boolean menu) {
		boolean cadastroValido = false;

		while (!cadastroValido) {
			try {
				this.name = JOptionPane.showInputDialog("Nome");
				if (this.name.trim().equals("")) {
					throw new Exception("Digite um nome!");
				}

				this.shirtNumber = Integer.parseInt(JOptionPane.showInputDialog("Número da camisa"));
				this.gols = Integer.parseInt(JOptionPane.showInputDialog("Gols no campeonato"));

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nErro no cadastro!");
				continue;
			}
			cadastroValido = true;
		}

	}

	public Player() {

	}

	@Override
	public String toString() {
		return "[Nome: " + name + ", Número: " + shirtNumber + ", Gols: " + gols + "]";
	}

}
