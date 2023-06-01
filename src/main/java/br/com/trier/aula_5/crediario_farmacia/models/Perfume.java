package br.com.trier.aula_5.crediario_farmacia.models;


public class Perfume extends Product{

	public Perfume(String name, int inventory, double value) {
		super(name, inventory, value);
	}

	@Override
	public void sale(Client client, int qnt) {
		 if(client.getBalance() - (getValue() * qnt) > -300) {
			super.sale(client, qnt); 
	}
		
	}
}
