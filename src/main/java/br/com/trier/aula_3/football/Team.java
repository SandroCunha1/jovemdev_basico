package br.com.trier.aula_3.football;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {

	private String name;
	private List<Player> players = new ArrayList<Player>();
	private int totalGols;

	public Team(boolean menu) {
		boolean addPlayer = true;
		int choose;
		boolean cadastroValido = false;

		while (!cadastroValido) {
			try {
				this.name = JOptionPane.showInputDialog("Nome da equipe");
				if (this.name.trim().equals("")) {
					throw new Exception("Digite um nome!");
				}
				do {
					choose = JOptionPane.showConfirmDialog(null, "Você deseja adicionar um novo jogador?");
					if (choose == 0) {
						players.add(new Player(true));
					} else {
						addPlayer = false;
					}

				} while (addPlayer);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nErro no cadastro!");
				continue;
			}
			cadastroValido = true;
		}

	}

	public Team() {

	}

	public String stringPlayers() {
		String ret = "";
		for (Player player : players) {
			ret += player.toString();
			ret += "\n";
		}
		return ret;
	}

	@Override
	public String toString() {
		return "Nome do time: " + name + "\nJogadores { \n" + stringPlayers() + "}\n\n";
	}

}
