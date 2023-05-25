package br.com.trier.aula_3.biblioteca;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import lombok.Getter;

@Getter
public enum EnumGender {

	MASCULINO(1, "Masculino"), 
	FEMININO(2, "Feminino");

	private int id;
	private String description;

	private EnumGender(int id, String description) {
		this.id = id;
		this.description = description;
	}

	static EnumGender buscaPorCodigo(int codigo) {
		for (EnumGender sex : EnumGender.values()) {
			if (codigo == sex.id) {
				return sex;
			}
		}
		return null;
	}

	/*
	 * static EnumGender escolheGenero() { String menu = "Gênero: \n"; for
	 * (EnumGender sex : EnumGender.values()) { menu += sex.id + " - " +
	 * sex.description + "\n"; } int escolha =
	 * Integer.parseInt(JOptionPane.showInputDialog(menu)); if
	 * (buscaPorCodigo(escolha) == null) { JOptionPane.showMessageDialog(null,
	 * "Gênero inválido!"); return escolheGenero(); } return
	 * buscaPorCodigo(escolha); }
	 */
	
	static EnumGender escolheGenero() {
        EnumGender[] genders = EnumGender.values();
        String[] genderDescriptions = new String[genders.length];
        for (int i = 0; i < genders.length; i++) {
            genderDescriptions[i] = genders[i].getId() + " - " + genders[i].getDescription();
        }

        JComboBox<String> comboBox = new JComboBox<>(genderDescriptions);
        int choice = JOptionPane.showConfirmDialog(null, comboBox, "Escolha um Gênero", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (choice == JOptionPane.OK_OPTION) {
            int selectedIndex = comboBox.getSelectedIndex();
            if (selectedIndex >= 0 && selectedIndex < genders.length) {
                return genders[selectedIndex];
            }
        }
        return null;
    }

}
