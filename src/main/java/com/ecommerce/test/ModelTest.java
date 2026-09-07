package com.ecommerce.test;

import com.ecommerce.model.Product;


public class ModelTest {
    public static void main(String[] args) {
		Product product = new Product();
		
		product.setProductId(1);
		product.setCategoryId(3);
		product.setProductName("Dell Insprion 15");
		product.setDescription("15-inch laptop");
		product.setPrice(58000.00);
		product.setStockQuantity(20);
		product.setStatus("ACTIVE");
		
		System.out.println("Product ID : " + product.getProductId());
		System.out.println("Product Name : " + product.getProductName());
		System.out.println("Product Price : " + product.getPrice());
		System.out.println("Product Stock : " + product.getStockQuantity());
		System.out.println("\nComplete Product : ");
		System.out.println(product);
	}
}
