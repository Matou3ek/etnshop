package cz.etn.etnshop.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository("productDao")
public class ProductDaoImpl extends AbstractDao implements ProductDao {

	@SuppressWarnings("unchecked")
	public List<Product> getProducts() {
		Criteria criteria = getSession().createCriteria(Product.class);
		return criteria.list();
	}

	@Override
	public Product find(int id) {
		Product product = (Product) getSession().createCriteria(Product.class).add(Restrictions.idEq(id)).uniqueResult();
	return product;
	}

	@java.lang.Override
	public void create(Product product) {
		Product newProduct = new Product();
		newProduct.setName(product.getName());
		newProduct.setSerialNumber(product.getSerialNumber());

		getSession().saveOrUpdate(newProduct);
		getSession().flush();
	}

	@java.lang.Override
	public void update(Product product) {
		Product foundProduct = find(product.getId());
		foundProduct.setName(product.getName());
		foundProduct.setSerialNumber(product.getSerialNumber());

		getSession().saveOrUpdate(foundProduct);
		getSession().flush();
	}

	@java.lang.Override
	public void indexProducts() {
         FullTextSession fullTextSession = Search.getFullTextSession(getSession());
         try {
			fullTextSession.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@java.lang.Override
    public List<Product> searchForProduct(String searchText) {
        FullTextSession fullTextSession = Search.getFullTextSession(getSession());
        
        QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
              org.apache.lucene.search.Query query = qb.keyword().onFields("name", "serial_number")
                .matching(searchText).createQuery();

              org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Product.class);

              List<Product> list = hibQuery.list();
		return null;
    }

}
