package br.com.trier.aula_5.crediario_farmacia.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class Client {

	private String name;
	@Getter private double balance = 0;
	
	public Client(String name) {
		super();
		this.name = name;
	}
	
	public void setBalance(double d) {
		if(d <= 0) {
			balance = d;
		}
	}	

}
