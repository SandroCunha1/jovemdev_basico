package br.com.trier.aula_5.crediario_farmacia.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.trier.aula_5.crediario_farmacia.models.HospiltalProducts;
import br.com.trier.aula_5.crediario_farmacia.models.Medicine;
import br.com.trier.aula_5.crediario_farmacia.models.Perfume;
import br.com.trier.aula_5.crediario_farmacia.models.Product;

public class ProductsDao {
	private List<Product> products = new ArrayList<>();
	
	public Product cadastra(Product product) {
		if(getProduct(product) == null) {
			products.add(product);
			return product;
		}
		return null;
		
	}
	
	public Product getProduct(Product product) {
			Product result = products.stream()
	            .filter(p -> p.equals(product))
	            .findFirst()
	            .orElse(null);

	    return result;
	}
	
	public List<Product> getAll() {
		return products;
	}
	
	public List<Product> getMedicine() {
		 List<Product> medicines = products.stream()
						            .filter(p -> p instanceof Medicine)
						            .collect(Collectors.toList());
		return medicines;
	}
	
	public List<Medicine> getPrescriptedMedicine() {
		 List<Medicine> medicines = products.stream()
		            .filter(p -> p instanceof Medicine && ((Medicine) p).isPrescription())
		            .map(p -> (Medicine) p)
		            .collect(Collectors.toList());

		    return medicines;
	}
	
	
	
	public List<Product> getHospitalProducts() {
		 List<Product> hospiltalProducts = products.stream()
						            .filter(p -> p instanceof HospiltalProducts)
						            .collect(Collectors.toList());
		return hospiltalProducts;
	}
	
	public List<Product> getPerfume() {
		 List<Product> perfumes = products.stream()
						            .filter(p -> p instanceof Perfume)
						            .collect(Collectors.toList());
		return perfumes;
	}
	

	
	
}
