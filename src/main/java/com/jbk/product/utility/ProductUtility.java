package com.jbk.product.utility;

import java.util.Scanner;

import com.jbk.product.entity.Product;

public class ProductUtility {

	public static Product PrepareProductData(Scanner scanner) {
		
		System.out.println("Enter Product Id");
		int productId=scanner.nextInt();
		
		System.out.println("Enter Product Name");
		String productName = scanner.next();
		
		System.out.println("Enter Product Price");
		double productPrice = scanner.nextDouble();
		
		System.out.println("Enter product MFG");
		String productMfg =scanner.next();
		
		System.out.println("Enter product Category");
		String productCategory = scanner.next();
		
		Product product =new Product(productId, productName, productPrice, productMfg, productCategory);
		return product;
}
}