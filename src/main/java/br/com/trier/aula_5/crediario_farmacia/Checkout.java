package br.com.trier.aula_5.crediario_farmacia;

import br.com.trier.aula_5.crediario_farmacia.models.Client;
import br.com.trier.aula_5.crediario_farmacia.models.Product;

public class Checkout {

	public void makeSale(Product product, Client client) {
		product.sale(client);
	}
	
	public void payDebt(Client client) {
		client.setBalance(0);
	}
	
	public boolean payDebt(Client client, double pay) {
		if(client.getBalance() + pay > 0 ) {
			return false;
		}
		client.setBalance(client.getBalance() + pay);
		return true;
	}
}
