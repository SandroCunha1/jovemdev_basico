package br.com.trier.aula_5.crediario_farmacia.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
public abstract class Product {
	private String name;
	@Getter protected int inventory;
	@Getter protected double value;
	
	public void sale(Client client, int qnt) {
		if (inventory - qnt > 0 ) {
			inventory -= qnt;
			client.setBalance(client.getBalance() - value * qnt);
		}
	}
	
	
}
