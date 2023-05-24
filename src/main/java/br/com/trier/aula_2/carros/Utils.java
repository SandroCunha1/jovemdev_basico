package br.com.trier.aula_2.carros;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Utils {

	static int escolheOp() {
		String menu = "1 - Cadastrar\n" + "2 - Listar carros por período de fabricação\n"
				+ "3 - Listar carros por marca\n" + "4 - Listar carros por cor\n" + "5 - Mostrar todos os carros\n\n"
				+ "6 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	static List<Car> dateFilter(List<Car> cars) {
		List<Car> carsInTheFormat = new ArrayList<Car>();
		boolean dataValida = false;
		int anoInicial = 0;
		int anoFinal = 0;

		while (!dataValida) {
			try {
				String stringDateInicio = JOptionPane.showInputDialog("Data inicio:");
				if (stringDateInicio.length() != 4) {
					throw new Exception("Ano inválido, formato esperado: (yyyy)");
				}
				anoInicial = Integer.parseInt(stringDateInicio);

				String stringDateFinal = JOptionPane.showInputDialog("Data final:");
				if (stringDateFinal.length() != 4) {
					throw new Exception("Ano inválido, formato esperado: (yyyy)");
				}
				anoFinal = Integer.parseInt(stringDateFinal);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nErro no filtro!");
				continue;
			}
			dataValida = true;
		}

		for (Car car : cars) {
			if (car.getManufacturingDate() >= anoInicial && car.getManufacturingDate() <= anoFinal) {
				carsInTheFormat.add(car);
			}
		}
		return carsInTheFormat;
	}

	static List<Car> brandFilter(List<Car> cars) {
		List<Car> carsInTheFormat = new ArrayList<Car>();
		String marca = "";
		boolean marcaValida = false;

		while (!marcaValida) {
			try {
				marca = JOptionPane.showInputDialog("Marca que você deseja procurar: ");
				if (marca.equals("")) {
					throw new Exception("Digite uma marca!");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nERRO !");
				continue;
			}
			marcaValida = true;
		}
		for (Car car : cars) {
			if (car.getbrand().equalsIgnoreCase(marca)) {
				carsInTheFormat.add(car);
			}
		}
		return carsInTheFormat;
	}

	static List<Car> colorFilter(List<Car> cars) {
		List<Car> carsInTheFormat = new ArrayList<Car>();
		Color color = Color.BRANCO;
		boolean corValida = false;

		while (!corValida) {
			try {
				int colorNumber = Integer.parseInt(JOptionPane.showInputDialog(Car.colorOptions()));
				color = Color.values()[colorNumber - 1];
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e + "\nCor inválida!");
				continue;
			}
			corValida = true;
		}

		for (Car car : cars) {
			if (car.getColor().equals(color)) {
				carsInTheFormat.add(car);
			}
		}
		return carsInTheFormat;
	}

	static void printCarArray(List<Car> cars) {
		String ret = "";
		for (Car car : cars) {
			ret += "\n-------------------------------------";
			ret += car.toString();
		}

		JOptionPane.showMessageDialog(null, ret);
	}

	static void printCarArray(List<Car> cars, List<Car> carsFiltered) {
		String ret = "";
		for (Car car : carsFiltered) {
			ret += "\n-------------------------------------";
			ret += car.toString();
		}

		ret += "\n\nPorcentagem: " + calcPercent(carsFiltered, cars) + "%";

		JOptionPane.showMessageDialog(null, ret);
	}

	static double calcPercent(List<Car> carsFiltered, List<Car> cars) {
		return ((double) carsFiltered.size() / cars.size()) * 100;

	}
}
