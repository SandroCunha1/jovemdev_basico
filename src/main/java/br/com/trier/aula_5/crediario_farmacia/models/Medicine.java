package br.com.trier.aula_5.crediario_farmacia.models;

import lombok.Getter;

public class Medicine extends Product{
	
		@Getter private boolean prescription;
	
		public Medicine(String name, int inventory, double value, boolean prescription) {
		super(name, inventory, value);
		this.prescription = prescription;
	}

		
		@Override
		public void sale(Client client) {
			if(!prescription)
				super.sale(client);
		}
		
		public void sale(Client client, String medico) {
			super.sale(client);
		}
	}
