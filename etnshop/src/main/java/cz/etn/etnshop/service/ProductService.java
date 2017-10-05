package cz.etn.etnshop.service;

import cz.etn.etnshop.dao.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {

	@Transactional(readOnly = true)
	List<Product> getProducts();

	@Transactional(readOnly = true)
	Product find(int id);

	@Transactional
	void update(Product product);

	@Transactional
	void create(Product product);
	
	@Transactional
	 List<Product> searchForProduct(String searchText);
}
