package br.com.trier.aula_5.sistema_bancario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class UniversityAccountTest {

	@Test
	void TesteConstructorNameNull() {
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			Account account = new UniversityAccount(0, "Caixa", null, 0);
		});
		
	}
	
	@Test
	void TesteAllConstructorNull() {
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			Account account = new UniversityAccount(0, null, null, 0);
		});
		
	}
	
	@Test
	void TesteConstructorAgencieNull() {
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			Account account = new UniversityAccount(0, null, "Sandro", 0);
		});
		
	}
	
	@Test
	void TesteConstructorBalanceSetMoreThan2000() {
			Account account = new UniversityAccount(0, "Caixa", "Sandro", 2001);
			assertEquals(0, account.balance);	
	}
	
	@Test
	void TesteConstructorBalanceSetLessThan2000() {
			Account account = new UniversityAccount(0, "Caixa", "Sandro", 1999);
			assertEquals(1999, account.balance);	
	}

}
