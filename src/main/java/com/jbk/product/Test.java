package com.jbk.product;

import java.util.List;
import java.util.Scanner;

import com.jbk.product.entity.Product;
import com.jbk.product.service.ProductService;
import com.jbk.product.utility.ProductUtility;

public class Test {
	private static char[] msg;

public static void main(String[] args) {
	
	
	
	Scanner scanner = new Scanner(System.in);
	ProductService service = new ProductService();
   int choice;
   char ch;
	do {
		System.out.println("**********Controller*********");
		System.out.println("Press 1 For Save Product");

		System.out.println("Press 2 For Get Product");

		System.out.println("Press 3 For Delete Product");
		
		System.out.println("Press 4 For Update");
		
		System.out.println("Press 5 For All Products");
		
		System.out.println("Press 6 For Restrictions Ex");
		
		System.out.println("Press 7 For Projections  ");
		
		choice = scanner.nextInt();
		
		switch(choice) {
		
		case 1:{
			Product product = ProductUtility.PrepareProductData(scanner);
		String msg =  service.saveProduct(product);
	System.out.println(msg);
			break;
		}
		
		case 2:{
			System.out.println("Enter Product Id");
			int productId = scanner.nextInt();
			Product product = service.getProductById(productId);
			if(product!=null) {
				System.out.println(product);
				
			}else {
				System.out.println("Product not Found");
			}
			break;
		}
		
		case 3:{
			System.out.println("Enter Product Id");
			int productId = scanner.nextInt();
			String msg = service.deleteProductById(productId);
		    System.out.println(msg);
			break;
		}
		case 4:{
			System.out.println("Update");
		   break;
		}
		case 5:{
			List <Product> list =service.getAllProducts();
			
			
		
		if(!list.isEmpty()) {
			for (Product product : list) {
			System.out.println(product);	
			}
		}
		else {
			System.out.println("Product Not Exists !!");
		}
		   break;
		
		}
		
		case 6:{
		List<Product> list = service.restrictionEx();
		if(!list.isEmpty()) {
			for (Product product : list) {
			System.out.println(product);	
			}
		}
		else {
			System.out.println("Product Not Exists !!");
		   break;
		}
		}
		
		case 7:{
			double sum = service.sumOfProductPrice();
			System.out.println(sum);
		   break;
		   
		}
		default:
			System.out.println("Invalid Choice !!");
			break;
		}
		System.out.println("Do  you want to continue y/n");
			ch= scanner.next().charAt(0);
		}while(ch=='y'||ch=='Y');System.out.println("Terminated");

}
}