package com.ecommerce.service;
import java.util.List;
import com.ecommerce.exception.*;
import com.ecommerce.dao.*;
import com.ecommerce.exception.*;
import com.ecommerce.model.*;

public class ProductService {
	
	private ProductDAO productDAO;
	
	public ProductService() {
		productDAO = new ProductDAO();
	}
	
	public boolean addProduct(Product product) throws ProductException {
		validateProduct(product);
		
		boolean result = productDAO.addProduct(product);
		
		if(!result) {
			throw new ProductException("Unable to create the product!");
		}
		return true;
	}
	
	private void validateProduct(Product product) throws ProductException {
		if(product == null) {
			throw new ProductException("Product can not be null!");
		}
		
		if(product.getProductName() == null || product.getProductName().trim().isEmpty()) {
			throw new ProductException("Product name can not be null!");
		}
		
		if(product.getPrice() <= 0) {
			throw new ProductException("Product price must be greater than zero!");
		}
		
		if(product.getStockQuantity() < 0) {
			throw new ProductException("Stock quantity can not be nagative");
		}
	}
	
	// Service for get product by id
	public Product getProductById(int productId) throws ProductException {
		if(productId < 0) {
			throw new ProductException("Invalid Product Id");
		}
		
		Product product = productDAO.getProductById(productId);
		
		if(product == null) {
			throw new ProductException("Product not found with Id : " + productId);
		}
		return product;
	}
	
	//Get all products
	public List<Product> getAllProducts(){
		return productDAO.getAllProducts();
	}
	
	// Update the product 
	public boolean updateProduct(Product product) throws ProductException {
		validateProduct(product);
		
		Product existingProduct  = productDAO.getProductById(product.getProductId());
		
		if(existingProduct == null) {
			throw new ProductException("Product does not exist");
		}
		
		boolean result = productDAO.updateProduct(product);
      
		if(!result) {
			throw new ProductException("Unable to update Product");
		}
		return true;
		
	}
	
	// delete product 
	
	public boolean deleteProduct(int productId) throws ProductException {
		if(productId < 0) {
			throw new ProductException("Invalid Product ID");
		}
		
		Product existingProduct = productDAO.getProductById(productId);
		
		if (existingProduct == null) {
			throw new ProductException("Product Does not exist");
		}
		
		boolean result = productDAO.deleteProduct(productId);
		
		
		if(!result ) {
			throw new ProductException("Unable to delete the Product ");
		}
		return true;
	}
}