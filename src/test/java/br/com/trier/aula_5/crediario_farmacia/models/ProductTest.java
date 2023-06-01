package br.com.trier.aula_5.crediario_farmacia.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void testeVendaMaiorQueEstoqueProdutosImportados() {
		Product product = new HospiltalProducts("Seringa", 0, 0);
		Client client = new Client("João");
		product.sale(client);
		assertEquals(-1, product.inventory);
	}
	
	void testeVendaMaiorQueEstoqueNaoimportados() {
		Product product1 = new Medicine("Dezopan", 0, 0, false);
		Product product2 = new Perfume("John", 0, 0);
		Client client = new Client("João");
		product1.sale(client);
		product2.sale(client);
		assertEquals(0, product1.inventory);
		assertEquals(0, product2.inventory);
	}

}
