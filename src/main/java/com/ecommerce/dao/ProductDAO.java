package com.ecommerce.dao;

import java.sql.*;
import java.util.*;
import com.ecommerce.model.*;
import com.ecommerce.util.DBConnection;

public class ProductDAO {
    public boolean addProduct(Product product) {
    	String sql = "insert into ecommproducts (category_id,product_name, description," +
                     " price,stock_quantity ,image_url, status)" +
    			     "values (?,?,?,?,?,?,?)";
    	try(Connection connection = DBConnection.getConnection(); 
    		PreparedStatement statement = connection.prepareStatement(sql)){
    		statement.setInt(1, product.getCategoryId());
    		statement.setString(2, product.getProductName());
    		statement.setString(3, product.getDescription());
    		statement.setDouble(4, product.getPrice());
    		statement.setInt(5, product.getStockQuantity());
    		statement.setString(6, product.getImageURL());
    		statement.setString(7, product.getStatus());
    		
    		int rows = statement.executeUpdate();
    		return rows > 0;
		} catch (Exception e) {
			e.printStackTrace();
            return false;
		}
    }
    // Fetch product id
    public Product getProductById(int productId) {
    	String sql = "select * from ecommproducts where product_id=?";
    	try(Connection connection = DBConnection.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(sql)) {
    		statement.setInt(1, productId);
    		
    		try (ResultSet resultSet = statement.executeQuery()){
				if(resultSet.next()) {
					Product product = new Product();
					product.setProductId(resultSet.getInt("product_id"));
					product.setCategoryId(resultSet.getInt("category_id"));
					product.setProductName(resultSet.getString("product_name"));
					product.setDescription(resultSet.getString("description"));
					product.setPrice(resultSet.getDouble("price"));
					product.setStockQuantity(resultSet.getInt("stock_quantity"));
					product.setImageURL(resultSet.getString("image_url"));
					product.setStatus(resultSet.getString("status"));
					
					return product;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
    	return null;
    }
    // fetch all product 
    public List<Product> getAllProducts(){
    	List<Product> products = new ArrayList<>();
    	
    	String sql = "select * from ecommproducts";
    	
    	try(Connection connection = DBConnection.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(sql);
    			ResultSet resultSet = statement.executeQuery();
    			) {
    		while(resultSet.next()) {
    			Product product = new Product();
    			
    			product.setProductId(resultSet.getInt("product_id"));
				product.setCategoryId(resultSet.getInt("category_id"));
				product.setProductName(resultSet.getString("product_name"));
				product.setDescription(resultSet.getString("description"));
				product.setPrice(resultSet.getDouble("price"));
				product.setStockQuantity(resultSet.getInt("stock_quantity"));
				product.setImageURL(resultSet.getString("image_url"));
				product.setStatus(resultSet.getString("status"));
    			
				products.add(product);
    		}
    		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return products;
    }
    // Update the product 
    public  boolean updateProduct(Product product) {
    	String sql = "update ecommproducts set " +
                      "category_id = ? , " +  
    			       "product_name = ?, " +
                      "description = ?, "+
    			       "price = ?, " +
                      "stock_quantity = ?, " +
    			       "image_url = ?, " +
                      "status = ? " + 
    			       "where product_id = ?";
    	try(Connection connection = DBConnection.getConnection(); 
        		PreparedStatement statement = connection.prepareStatement(sql);
    			){
    		statement.setInt(1, product.getCategoryId());
    		statement.setString(2, product.getProductName());
    		statement.setString(3, product.getDescription());
    		statement.setDouble(4, product.getPrice());
    		statement.setInt(5, product.getStockQuantity());
    		statement.setString(6, product.getImageURL());
    		statement.setString(7, product.getStatus());
    		statement.setInt(8, product.getProductId());
    		
    		int rows = statement.executeUpdate();
    		return rows > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
    
    // 
    
   public boolean deleteProduct(int productId) {
	   String sql = "delete from ecommproducts where product_id = ?";
	   
	   try (Connection connection = DBConnection.getConnection(); 
       		PreparedStatement statement = connection.prepareStatement(sql);
   			){
		   statement.setInt(1, productId);
		   
		   int rows = statement.executeUpdate();
		   
		   return rows > 0;
		
	} catch (Exception e) {
		e.printStackTrace();
        return false;
	}
   }
}
