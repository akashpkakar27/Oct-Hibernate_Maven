package com.jbk.product.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.property.access.spi.PropertyAccessBuildingException;

import com.jbk.product.config.HibernateUtility;
import com.jbk.product.entity.Product;
//import com.jbk.product.exception.ProductAlreadyExistsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ProductDao {
	private SessionFactory sessionFactory;

	public ProductDao() {
		sessionFactory = HibernateUtility.getSessionFactory();

	}

	public String saveProduct(Product product) {
		Session session = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product dbProduct = session.get(Product.class, product.getProductId());
			if (dbProduct == null) {
				session.save(product);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		if (isAdded) {
			return "saved !!";
		} else {
			return "Already Exists";
		}
	}

	public Product getProductById(int productId) {
		Session session = null;
		Product product = null;
		try {
			session = sessionFactory.openSession();
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;

	}

	public String deleteProductById(int productId) {
		Session session = null;
		String msg = null;
		try {
			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product product = session.get(Product.class, productId);
			if (product != null) {
				session.delete(product);
				transaction.commit();
				msg = "Deleted";
			} else {
				msg = "Product Not Exists With Id =" + productId;
//		session.delete(product);
//		transaction.commit();
//		msg="Deleted";
//	} else {
//	
//		msg="Product Not Exists With Id ="+productId;
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Product> getAllProducts() {
		Session session = null;
		List<Product> list = null;
		try {
			session = sessionFactory.openSession();

			Criteria criteria = session.createCriteria(Product.class);

//			criteria.addOrder(Order.asc("productPrice"));
			criteria.setFirstResult(0);
			criteria.setMaxResults(3);

			list = criteria.list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public List<Product> restrictionEx() {
		Session session = null;
		List<Product> list = null;
		try {

			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
//		Map<String,Object> map = new HashMap<String, Object>();
			Map<String, Object> map = new HashMap<String, Object>();
//		map.put("productName","Pen");
//		map.put("productPrice",10d);
//		Criterion crt = Restrictions.allEq(map);
//	Criterion name=	Restrictions.eq("productName", "Pen");
//	Criterion price=Restrictions.eq("productPrice", 10d);

//		criteria.add(Restrictions.or(name,price));
//		criteria.add(Restrictions.between("productPrice",1d,500d));
//        criteria.add(Restrictions.in("productPrice", 7d,500d,100d));
			criteria.add(Restrictions.like("productName", "o"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public double sumOfProductPrice() {
		Session session = null;
		double sum = 0;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			criteria.setProjection(Projections.sum("productPrice"));
//			criteria.list();
			List<Double>list = criteria.list();
			sum=list.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();

			}
		}
		return sum;
	}

}
