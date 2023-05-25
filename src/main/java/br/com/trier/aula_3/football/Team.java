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

	public Team() {
	}
	
	public void registerTeam() {
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
						this.players.add(new Player());
						this.players.get(this.players.size() - 1).registerPlayer();;
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

	
	public Player getTopPlayer() {
		Player topPlayer = new Player();
		 topPlayer.setGols(players.get(0).getGols());
		for (Player player : players) {
				if (player.getGols() >= topPlayer.getGols()) {
					topPlayer.setName(player.getName());
					topPlayer.setShirtNumber(player.getShirtNumber());
					topPlayer.setGols(player.getGols());
				}
			}
		
		return topPlayer;
	}
	
	public int getGols() {
		int totalGols = 0;
		for (Player player : players) {
			totalGols += player.getGols();
		}
		return totalGols;
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
	
	public String toString(boolean players) {
		return "Nome do time: " + name + "\n\n";
	}

}
