package com.ecommerce.test;

import com.ecommerce.model.*;

import java.util.List;
import java.util.Scanner;

import com.ecommerce.dao.*;


public class ProductDAOTest {
   public static void main(String[] args) {
	
	   Scanner sc = new Scanner(System.in);
	   
	   Product product = new Product();
	   
	  
	   
	   ProductDAO productDAO = new ProductDAO();
	   System.out.println("Please select the option \n1. Create Product \n2. Fetch Product By Id \n3. Get All Products \n4. Update Existing Product  \n5. Delete Product  ");
	   int choice = sc.nextInt();
	   
	   
	   switch(choice) {
	   case 1 : 
		   product.setCategoryId(3);
		   product.setProductName("Lenovo IdeaPad Slim 5");
		   product.setDescription("15 inch business Laptop");
		   product.setPrice(57842.35);
		   product.setStockQuantity(20);
		   product.setImageURL("https://m.media-amazon.com/images/I/51b5IABKyrL._SY300_SX300_QL70_FMwebp_.jpg");
		   product.setStatus("ACTIVE");
		   
		   boolean result = productDAO.addProduct(product);
		   if(result) {
			   System.out.println("Product Inserted Successfully!!");
		   }
		   else {
			System.out.println("Product Inserted Failed!! ");
		}
		   break;
		   
	   case 2:
		   Product product2 = productDAO.getProductById(8);
		   if(product2 != null) {
			   System.out.println("Product Found");
			   
			   System.out.println("Id : " + product2.getProductId());
			   System.out.println("Category Id : " + product2.getCategoryId());
			   System.out.println("Product Name  : " + product2.getProductName());
			   System.out.println("Product Description : " + product2.getDescription());
			   System.out.println("Product Price Rs : " + product2.getPrice());
			   System.out.println("Product Stock Quantity : " + product2.getStockQuantity());
			   System.out.println("Product Status : " + product2.getStatus());
			   
		   }
		   else {
			   System.out.println("Product Not Found!!");
		   }
		   break;
		   
	   case 3:
		     System.out.println("--------- All Products --------");
		     List<Product> products = productDAO.getAllProducts();
		     
		     for(Product product3 : products ) {
		    	 System.out.println(product3.getCategoryId()
		    			 + " |" 
		    			 + product3.getProductName()
		    			 + "|"
		    			 + product3.getPrice()
		    			 + " | Rs."
		    			 + product3.getStockQuantity());
		    	 
		     }
		   break;
		   
	   case 4:
		   Product product4 = productDAO.getProductById(8);
		   if(product4 != null) {
			   System.out.println("Product Found");
			   
			   product4.setCategoryId(4);
			   product4.setProductName("Lenovo IdeaPad Slim 5 pro");
			   product4.setDescription("15 inch business Laptop for Lowest Price");
			   product4.setPrice(65003.35);
			   product4.setStockQuantity(30);
			   product4.setImageURL("https://m.media-amazon.com/images/I/51b5IABKyrL._SY300_SX300_QL70_FMwebp_.jpg");
			   product4.setStatus("ACTIVE");
			  
			   boolean updated = productDAO.updateProduct(product4);
			   if(updated) {
				   System.out.println("Product Updated Successfully !!");
			   }
			   
		   }
		   else {
			   System.out.println("Product Not Found!!");
		   }
		   break;
		   
	   case 5:
		   boolean deleted = productDAO.deleteProduct(4);
		   if(deleted) {
			   System.out.println("Product deleted successfully!");
		   }
		   else {
			   System.out.println("Product Not Found!");
		   }
		   break;
		   
		   default:
			   System.out.println("Invalid Choice!!");
	   }
	
}
  
}
