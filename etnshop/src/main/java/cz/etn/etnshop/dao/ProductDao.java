package cz.etn.etnshop.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductDao {

	@Transactional(readOnly = true)
	List<Product> getProducts();

	@Transactional(readOnly = true)
	Product find(int id);

	@Transactional
	void create(Product product);

	@Transactional
	void update(Product product);

	@Transactional
	void indexProducts();

	@Transactional(readOnly = true)
	List<Product> searchForProduct(String searchText);
	
}
