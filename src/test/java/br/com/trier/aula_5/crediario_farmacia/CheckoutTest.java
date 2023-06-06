package br.com.trier.aula_5.crediario_farmacia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_4.diciplinas.models.Discipline;
import br.com.trier.aula_5.crediario_farmacia.models.Client;
import br.com.trier.aula_5.crediario_farmacia.models.HospiltalProducts;
import br.com.trier.aula_5.crediario_farmacia.models.Medicine;
import br.com.trier.aula_5.crediario_farmacia.models.Perfume;
import br.com.trier.aula_5.crediario_farmacia.models.Product;
import br.com.trier.aula_5.crediario_farmacia.repository.ProductsDao;

class CheckoutTest {

	Checkout checkout;
	ProductsDao dao;
	Client client;
	Product product1;
	Product product2;
	Product product3;
	Product product4;
	
	@BeforeEach
	void init() {
		checkout = new Checkout();
			dao  = new ProductsDao();
			
			product1 = new Medicine("Benzoplan", 20, 20.0, false);
			dao.cadastra(product1);
			product2 = new Medicine("Benzoplan", 20, 20.0, true);
			dao.cadastra(product2);
			product3 = new Perfume("Benzoplan", 20, 20.0);
			dao.cadastra(product3);
			product4 = new HospiltalProducts("Benzoplan", 20, 20.0);
			dao.cadastra(product4);
			
			client = new Client("João");
	}
	
	
	@Test
	void fazendoUmaVendaBemSucedida() {
		int inventoryInit = product1.getInventory();
		checkout.makeSale(product1, client, 1);
		assertEquals(inventoryInit - 1, product1.getInventory());
		assertEquals(client.getBalance() + product1.getValue(), 0);
	}
	
	@Test
	void fazendoUmaVendaMalSucedidaDePerfume() {
		int inventoryInit = product3.getInventory();
		client.setBalance(-301);
		checkout.makeSale(product3, client, 1);
		assertEquals(inventoryInit, product3.getInventory());
		assertEquals(client.getBalance(), -301);
	}
	
	@Test
	void fazendoUmaVendaMalSucedidaDeMedicamentosQuePrecisaDeprescricao() {
		int inventoryInit = product2.getInventory();
		checkout.makeSale(product2, client, 1);
		assertThrows(Exception.class ,() -> {
    		Checkout checkout = new Checkout();
    		checkout.makeSale(product2, client, 1);
        	}); 
		assertEquals(inventoryInit, product2.getInventory());
	}
	
@Test
	void pagandoDebtoTotal() {
		client.setBalance(-301);
		checkout.payDebt(client);
		assertEquals(0, client.getBalance());
	}
	
	@Test
	void pagandoDebtoParcial() {
		client.setBalance(-301);
		checkout.payDebt(client, 300);
		assertEquals(-1, client.getBalance());
	}
	
	@Test
	void pagandoDebtoParcialInvalid() {
		client.setBalance(-301);
		checkout.payDebt(client, 302);
		assertEquals(-301, client.getBalance());
	}
	
	

}
