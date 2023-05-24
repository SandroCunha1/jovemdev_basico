package br.com.trier.aula_3.football;

import java.util.List;
import javax.swing.JOptionPane;

public class Utils {

	static int escolheOp() {
		String menu = "1 - Cadastrar time\n" + "2 - Listar todos os jogadores de um time\n"
				+ "3 - Verificar artilheiro do campeonato\n" + "4 - Verificar time com mais gols\n"
				+ "5 - Mostrar todos os times\n\n" + "6 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	static String printTeams(List<Team> teams) {
		String ret = "";
		for (Team team : teams) {
			ret += team.toString();
		}
		return ret;
	}

	static Team chooseTeam(List<Team> teams) {
		String teamName = "";
		try {
			teamName = JOptionPane.showInputDialog("Escolha um time para ver os jogadores: \n" + printTeams(teams));
			if (teamName.trim().equals("")) {
				throw new Exception("Digite um nome!");
			}
		} catch (Exception e) {
			chooseTeam(teams);
		}

		for (Team team : teams) {
			if (team.getName().equalsIgnoreCase(teamName)) {
				return team;
			}
		}
		return null;
	}

	static Player getTopPlayer(List<Team> teams) {
		Player topPlayer = new Player();
		topPlayer.setGols(0);
		for (Team team : teams) {
			for (int i = 0; i < team.getPlayers().size(); i++) {
				Player player = team.getPlayers().get(i);
				if (player.getGols() > topPlayer.getGols()) {
					topPlayer.setName(player.getName());
					topPlayer.setShirtNumber(player.getShirtNumber());
					topPlayer.setGols(player.getGols());
				}
			}
		}
		return topPlayer;
	}

	static Team getTopGolsTeam(List<Team> teams) {
		Team topGolsTeam = new Team();
		topGolsTeam.setTotalGols(0);

		for (Team team : teams) {
			int totalGols = 0;
			for (int i = 0; i < team.getPlayers().size(); i++) {
				Player player = team.getPlayers().get(i);
				totalGols += player.getGols();
			}
			team.setTotalGols(totalGols);
			if (team.getTotalGols() > topGolsTeam.getTotalGols()) {
				topGolsTeam.setName(team.getName());
				topGolsTeam.setPlayers(team.getPlayers());
				topGolsTeam.setTotalGols(totalGols);
			}

		}
		return topGolsTeam;
	}

}
