package cz.etn.etnshop.service;

import cz.etn.etnshop.dao.Product;
import cz.etn.etnshop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getProducts() {
		return productDao.getProducts();
	}

	@Override
	public Product find(int id) {
		return productDao.find(id);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

	@Override
	public void create(Product product){
		productDao.create(product);
	}
	
	@Override
	public List<Product> searchForProduct(String searchText){
		return productDao.searchForProduct(searchText);
	}

}
