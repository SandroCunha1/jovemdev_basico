package br.com.trier.aula_2.carros;

import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
	public static final String DATE_FORMAT = "dd/MM/yyyy";

	private int manufacturingDate;
	private String brand;
	private Color color;

	public Car() {

	}

	public void cadastraCarro() {
		boolean cadastroValido = false;

		while (!cadastroValido) {
			try {
				this.brand = JOptionPane.showInputDialog("Marca: ");
				if (brand.trim().equals("")) {
					throw new Exception("Digite uma marca!");
				}
				String stringDate = JOptionPane.showInputDialog("Data de fabricação:");
				if (stringDate.trim().length() != 4) {
					throw new Exception("Ano inválido, formato esperado: (yyyy)");
				}
				this.manufacturingDate = Integer.parseInt(stringDate);

				int colorNumber = Integer.parseInt(JOptionPane.showInputDialog(colorOptions()));
				this.color = Color.values()[colorNumber - 1];

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nErro no cadastro!");
				continue;
			}
			cadastroValido = true;
		}
	}


	public static String colorOptions() {
		Color[] corlors = Color.values();
		String colorOptions = "";
		for (int i = 0; i < corlors.length; i++) {
			colorOptions += (i + 1) + ". " + corlors[i] + "\n";
		}
		return colorOptions;
	}

	@Override
	public String toString() {
		return "\n" + this.brand + "\nAno: " + this.manufacturingDate + "\nCor: " + this.color;
	}

}
