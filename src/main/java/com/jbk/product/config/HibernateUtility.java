package com.jbk.product.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jbk.product.entity.Product;

public class HibernateUtility {

	public static SessionFactory getSessionFactory() {
		
		Configuration configuration = new Configuration();
		
		configuration.configure().addAnnotatedClass(Product.class);
		SessionFactory sessionFactory= configuration.buildSessionFactory();
		
		return sessionFactory;
}
}