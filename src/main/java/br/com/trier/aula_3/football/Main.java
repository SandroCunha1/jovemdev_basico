package br.com.trier.aula_3.football;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		List<Team> teams = new ArrayList<Team>();

		int op = 0;

		do {
			try {
				op = Utils.escolheOp();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "DIGITE UM NÚMERO!");
				continue;
			}

			if (op == 1) {
				teams.add(new Team(true));
			} else if (op == 2) {
				try {
					JOptionPane.showMessageDialog(null, Utils.chooseTeam(teams).toString());
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "Time não encontrado! ");
					continue;
				}
			} else if (op == 3) {
				JOptionPane.showMessageDialog(null, Utils.getTopPlayer(teams).toString());
			} else if (op == 4) {
				JOptionPane.showMessageDialog(null, Utils.getTopGolsTeam(teams).toString());
			} else if (op == 5) {
				JOptionPane.showMessageDialog(null, Utils.printTeams(teams));
			}
		} while (op != 6);
	}
}
