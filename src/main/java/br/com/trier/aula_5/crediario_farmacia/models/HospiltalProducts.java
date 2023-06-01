package br.com.trier.aula_5.crediario_farmacia.models;

public class HospiltalProducts extends Product {

	public HospiltalProducts(String name, int inventory, double value) {
		super(name, inventory, value);
	}

	@Override
	public void sale(Client client) {
		inventory -= 1;
		client.setBalance(client.getBalance() - value);
	}
}
