package br.com.trier.aula_5.sistema_bancario;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class Caixa {

	Account account;
	
	public boolean deposit(double qnt) {
		return account.deposit(qnt);
	}
	
	public boolean withdraw(double qnt) {
		return account.withdraw(qnt);
	}
	
	public boolean transfer(double qnt, Account account) {
		return this.account.transfer(qnt, account);
			
	}
}
