package br.com.trier.aula_5.sistema_bancario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaixaTest {

	Caixa caixa;
	Account account1; 
	Account account2;
	Account account3;
	@BeforeEach
	void init() {
		account1 = new CurrentAccount(123, "Caixa", "Sandro", 100);
		account2 = new SpecialAccount(122, "Banco do Brasil", "Mario", 100, 50);
		account3 = new UniversityAccount(121,"Caixa", "Evelyn", 1000);
	}
	
	@Test
	void testDepositeWithCurrentAccount() {
		caixa = new Caixa(account1);
		assertTrue(caixa.deposit(10000));
	}
	@Test
	void testDepositeWithSpecialAccount() {
		caixa = new Caixa(account2);
		assertTrue(caixa.deposit(10000));
	}
	@Test
	void testDepositeWithUniversityAccountWithValueLessThan2000() {
		caixa = new Caixa(account3);
		assertTrue(caixa.deposit(100));
	}
	
	@Test
	void testDepositeWithUniversityAccountWithValueMoreThan2000() {
		caixa = new Caixa(account3);
		assertFalse(caixa.deposit(2000));
	}
	
	
	
	@Test
	void testWithdrawWithCurrentAccountValid() {
		caixa = new Caixa(account1);
		assertTrue(caixa.withdraw(50));
	}
	
	@Test
	void testWithdrawWithCurrentAccountInvalid() {
		caixa = new Caixa(account1);
		assertFalse(caixa.withdraw(10000));
	}
	@Test
	void testWithdrawWithSpecialAccountValid() {
		caixa = new Caixa(account2);
		assertTrue(caixa.withdraw(150));
	}
	
	@Test
	void testWithdrawWithSpecialAccountInvalidByLimit() {
		caixa = new Caixa(account2);
		assertFalse(caixa.withdraw(151));
	}
	
	
	@Test
	void testWithdrawWithUniversityAccountValid() {
		caixa = new Caixa(account1);
		assertTrue(caixa.withdraw(50));
	}
	
	@Test
	void testWithdrawWithUniversityAccountInvalid() {
		caixa = new Caixa(account1);
		assertFalse(caixa.withdraw(10000));
	}
	
	
	
	@Test
	void testTransferWithCurrentAccountValid() {
		caixa = new Caixa(account1);
		assertTrue(caixa.transfer(50, account2));
	}
	
	@Test
	void testTransferWithCurrentAccountInvalid() {
		caixa = new Caixa(account1);
		assertFalse(caixa.transfer(10000, account2));
	}
	
	@Test
	void testTransferWithSpecialAccountValid() {
		caixa = new Caixa(account2);
		assertTrue(caixa.transfer(150, account1));
	}
	
	@Test
	void testTransferWithSpecialAccountInvalidByLimit() {
		caixa = new Caixa(account2);
		assertFalse(caixa.transfer(151, account1));
	}
	
	@Test
	void testTransferWithUniversityAccountValid() {
		caixa = new Caixa(account3);
		assertTrue(caixa.transfer(50, account2));
	}
	
	@Test
	void testTransferWithUniversityAccountInvalid() {
		caixa = new Caixa(account3);
		assertFalse(caixa.transfer(10000, account2));
	}
	
	@Test
	void testTransferWithSpecialAccountInvalidByBalance() {
		caixa = new Caixa(account2);
		assertFalse(caixa.transfer(1000, account1));
	}
	
	@Test
	void testTransfereringMoreThan2000ToUniversityAccount() {
		account2.deposit(2000);
		caixa = new Caixa(account2);	
		assertFalse(caixa.transfer(2001, account3));

	}

}
