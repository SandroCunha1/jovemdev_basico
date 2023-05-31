package br.com.trier.aula_5.sistema_bancario;

import lombok.NonNull;

public class UniversityAccount extends Account {

	public UniversityAccount(int number, @NonNull String agencie, @NonNull String ownerAccount, double balance) {
		super(number, agencie, ownerAccount);
		if(balance < 2000) {
			super.balance = balance;
		}
	}

	@Override
	public boolean deposit(double qnt) {
		if(balance + qnt <= 2000) {
			return super.deposit(qnt);
		}
		return false;
	}
	

}
