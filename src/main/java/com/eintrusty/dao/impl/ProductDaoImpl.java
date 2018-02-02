package com.eintrusty.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.eintrusty.dao.ProductDao;
import com.eintrusty.entity.Product;

@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		String hql = "FROM Product";

		return (List<Product>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub

		return entityManager.find(Product.class, productId);
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		entityManager.persist(product);

	}

	@Override
	public void updateProduct(Product product) {
		Product prod = getProductById(product.getProductId());
		prod.setProductName(product.getProductName());
		prod.setCategoryId(product.getCategoryId());
		prod.setSuplierId(product.getSuplierId());
		prod.setQuantity(product.getQuantity());
		prod.setUnitPrice(product.getUnitPrice());
		entityManager.flush();
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		entityManager.remove(getProductById(productId));

	}

	// contoh hql dengan parameter tertentu.
	public List<Product> search(String search) {
		Date now = new Date();
		List<Product> searchProduct = entityManager.createQuery("select  from Cat as cat where cat.birthdate < ?1")
				.setParameter(1, now, TemporalType.DATE).getResultList();
		return searchProduct;
	}

	// query native tipe 1
	public List<Product> queryNative(String expectedDuration) {
		String queryNative = "select night.id nid, night.night_duration, night.night_date, area.id aid, "
				+ "night.area_id, area.name from Night night, Area area where night.area_id = area.id "
				+ "and night.night_duration >= ?";
		Query query = entityManager.createNativeQuery(queryNative, "GetNightAndArea");
		query.setParameter(1, expectedDuration);
		return query.getResultList();
	}

	// query native tipe 2
	public List<Product> queryNativeTipeDua() {
		String sqlQuery = "select * from tbl_product where owner = ?";
		Query q = entityManager.createNativeQuery(sqlQuery, Product.class);
		q.setParameter(1, "Han");
		return q.getResultList();
	}

	// query native tipe 3 join table
	public List<Product> queryNaviveTiga() {
		List<Product> arr = (List<Product>) entityManager
				.createQuery("SELECT NEW jpqlexample.servlets.LineItemSum(p.price, l.quantity)"
						+ "FROM PurchaseOrder o JOIN o.orderLineItems l JOIN l.product p JOIN p.supplier s "
						+ "WHERE s.sup_name = 'Tortuga Trading'")
				.getResultList();
		return arr;
	}
	@Override
   public List<Product> getAllProductNative() {
	   String sqlString = "Select p from Product p where p.productId = 1";
	   List<Product> products = (List<Product>) entityManager.createQuery(sqlString)
			   .getResultList();
	   return products;
   }
}
