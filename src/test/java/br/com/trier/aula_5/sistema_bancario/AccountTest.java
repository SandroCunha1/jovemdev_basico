package br.com.trier.aula_5.sistema_bancario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void testConstructorNonNull() {
		Account account = new CurrentAccount(0, "Agencie", "Owner", 1000.0);
		assertEquals(0, account.getNumber());
		assertEquals("Agencie", account.getAgencie());
		assertEquals("Owner", account.getOwnerAccount());
		assertEquals(1000.0, account.getBalance());
	}

	

	@Test
	void testConstructorAgencieNull() {
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			Account account = new CurrentAccount(0, null, "Owner", 1000.0);
		});
	}

	@Test
	void testConstructorOwnerAccountNull() {
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			Account account = new CurrentAccount(0, "Agencie", null, 1000.0);
		});
	}

	

}
