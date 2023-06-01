package br.com.trier.aula_5.crediario_farmacia.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.trier.aula_5.crediario_farmacia.models.HospiltalProducts;
import br.com.trier.aula_5.crediario_farmacia.models.Medicine;
import br.com.trier.aula_5.crediario_farmacia.models.Perfume;
import br.com.trier.aula_5.crediario_farmacia.models.Product;

class ProductsDaoTest {

	ProductsDao dao;
	Product product1;
	@BeforeEach
	void init() {
		dao  = new ProductsDao();
		product1 = new Medicine("Benzoplan", 20, 20.0, false);
		Product product2 = new Medicine("Benzoplan", 20, 20.0, true);
		dao.cadastra(product2);
		Product product3 = new Perfume("Benzoplan", 20, 20.0);
		dao.cadastra(product3);
		Product product4 = new HospiltalProducts("Benzoplan", 20, 20.0);
		dao.cadastra(product4);
		dao.cadastra(product1);
	}
	
	@Test
	void cadastraTeste() {
		dao.cadastra(new Perfume(null, 0, 0));
		assertEquals(5, dao.getAll().size());
	}
	
	@Test
	void tentaCadastrarUmProdutoJaCadastrado() {
		dao.cadastra(product1);
		assertEquals(4, dao.getAll().size());
	}
	
	@Test
	void pegaProdutoCadastrado() {
		assertEquals(product1, dao.getProduct(product1));
	}
	
	@Test
	void tentaPegarProdutoNaoCadastrado() {
		Product productT = new Medicine("Benzoplan", 20, 20.0, false);
		assertEquals(null, dao.getProduct(productT));
	}
	
	@Test
	void pegaTodosOsMedicamentosNaListaProduto() {
		assertEquals(2, dao.getMedicine().size());
	}
	
	@Test
	void pegaTodosOsMedicamentosComPrescricaoNaListaProduto() {
		assertEquals(1, dao.getPrescriptedMedicine().size());
	}
	
	@Test
	void pegaTodosOsPerfumesoNaListaProduto() {
		assertEquals(1, dao.getPerfume().size());
	}
	
	@Test
	void pegaTodosOsProdutosHospitalaresNaListaProduto() {
		assertEquals(1, dao.getHospitalProducts().size());
	}

}
