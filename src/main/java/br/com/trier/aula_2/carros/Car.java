package br.com.trier.aula_2.carros;


import javax.swing.JOptionPane;

public class Car {
	public static final String DATE_FORMAT = "dd/MM/yyyy";

	private int manufacturingDate;
	private String brand;
	private Color color;

	public Car() {

	}

	public void cadastraCarro() {
		boolean dataValida = false;

		while (!dataValida) {
			try {
				this.brand = JOptionPane.showInputDialog("Marca: ");
				if(this.getbrand().equals("")) {
					throw new Exception("Digite uma marca!");
				}
				String stringDate = JOptionPane.showInputDialog("Data de fabricação:");
				if(stringDate.length() != 4) {
					throw new Exception("Ano inválido, formato esperado: (yyyy)");
				}
				this.manufacturingDate = Integer.parseInt(stringDate);
				
				int colorNumber = Integer.parseInt(JOptionPane.showInputDialog(colorOptions()));
				this.color = Color.values()[colorNumber - 1];
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,  e + "\nErro no cadastro!" );
				continue;
			}
			dataValida = true;
		}
	}

	public int getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(int manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getbrand() {
		return brand;
	}

	public void setbrand(String brand) {
		this.brand = brand;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
		return "\nCarro [Data de fabricação =" + manufacturingDate + ", Marca =" + brand + ", Cor =" + color + "]";
	}
	
	


}
