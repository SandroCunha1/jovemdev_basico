package br.com.trier.aula_5.sistema_bancario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public abstract class Account {
	@NonNull
	private Integer number;
	@NonNull
	private String agencie;
	@NonNull
	private String ownerAccount;
	protected double balance;
	

	public boolean deposit(double qnt) {
		balance += qnt;
		return true;
	}
	
	public boolean withdraw(double qnt) {
		if(balance >= qnt) {
			balance -= qnt;
			return true;
			}
			return false;		
	}
	
	public boolean transfer(double qnt, Account account) {
			if (account.deposit(qnt)) {
				return withdraw(qnt);
			}
		
		return false;

	}

	

}
