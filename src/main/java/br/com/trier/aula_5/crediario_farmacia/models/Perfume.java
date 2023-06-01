package br.com.trier.aula_5.crediario_farmacia.models;


public class Perfume extends Product{

	public Perfume(String name, int inventory, double value) {
		super(name, inventory, value);
	}

	@Override
	public void sale(Client client) {
		 if(client.getBalance() > -300) {
			super.sale(client); 
		 }
		
	}
}
