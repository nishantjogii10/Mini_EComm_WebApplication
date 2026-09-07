package com.ecommerce.test;
import com.ecommerce.exception.*;
import com.ecommerce.service.*;
import com.ecommerce.dao.*;
import com.ecommerce.model.*;

public class ProductServiceTest {
    public static void main(String[] args) {
		ProductService productService = new ProductService();
		
		Product product = new Product();
		
		
		product.setCategoryId(3);
		product.setProductName("Acer Aspire 5");
		product.setDescription("PowerFull laptop for Gaming");
		product.setPrice(56000);
		product.setStockQuantity(14);
		product.setImageURL("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPc3FXPY81IY9amHxlsxZnTTS9wlUI33QVM52bpfUWlQ&s=10.jpg");
		product.setStatus("ACTIVE");
		
		try {
			boolean result = productService.addProduct(product);
			
			if(result) {
				System.out.println("Product added Successfully !");
			}
		} catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
	}
}
