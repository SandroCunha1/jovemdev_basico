package br.com.trier.aula_2.carros;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<Car>();

		int op = 0;

		do {
			try {
				op = Utils.escolheOp();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "DIGITE UM NÚMERO!");
				continue;
			}

			if (op == 1) {
				Car c = new Car();
				c.cadastraCarro();
				cars.add(c);
			} else if (op == 2) {
				Utils.printCarArray(cars, Utils.dateFilter(cars));
			} else if (op == 3) {
				Utils.printCarArray(cars, Utils.brandFilter(cars));
			} else if (op == 4) {
				Utils.printCarArray(cars, Utils.colorFilter(cars));
			} else if (op == 5) {
				Utils.printCarArray(cars);
			}
		} while (op != 6);

	}
}
