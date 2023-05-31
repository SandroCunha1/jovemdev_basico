package br.com.trier.aula_5.sistema_bancario;


public class SpecialAccount extends Account {
	private double limit;
	
	public SpecialAccount(int number, String agencie, String ownerAccount, double balance, double limit) {
		super(number, agencie, ownerAccount, balance);
		this.limit = limit;
	}


	@Override
	public boolean withdraw(double qnt) {
		if(balance + limit >= qnt) {
			balance -= qnt;
			return true;
			}
			return false;		
	}

	@Override
	public boolean transfer(double qnt, Account account) {
		if(balance + limit >= qnt) {
			return super.transfer(qnt, account);
			}
			return false;
	}
	
	
}
