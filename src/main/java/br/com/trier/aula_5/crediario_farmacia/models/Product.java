package br.com.trier.aula_5.crediario_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public abstract class Product {
	private String name;
	@Getter protected int inventory;
	@Getter protected double value;
	
	public void sale(Client client) {
		if (inventory > 0 ) {
			inventory -= 1;
			client.setBalance(client.getBalance() - value);
		}
	}
	
}
