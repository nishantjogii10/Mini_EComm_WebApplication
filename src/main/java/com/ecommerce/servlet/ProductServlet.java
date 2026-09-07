package com.ecommerce.servlet;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import com.ecommerce.model.*;
import com.ecommerce.exception.*;
import com.ecommerce.service.*;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    	String action = request.getParameter("action");
       try {
		   
    	   if ("edit".equals(action)) {

               String idParam = request.getParameter("id");

               if (idParam == null || idParam.trim().isEmpty()) {

                   response.sendError(
                           HttpServletResponse.SC_BAD_REQUEST,
                           "Product ID is required"
                   );

                   return;
               }

               int productId = Integer.parseInt(idParam);

               Product product =
                       productService.getProductById(productId);

               request.setAttribute("product", product);

               request.getRequestDispatcher(
                       "/edit-product.jsp"
               ).forward(request, response);

               return;
           }
    	   // =================================================
           // DISPLAY ALL PRODUCTS
           // =================================================
    	   List<Product> products =
                   productService.getAllProducts();

           request.setAttribute("products", products);

           request.getRequestDispatcher(
                   "/product-list.jsp"
           ).forward(request, response);
    	   
	} catch (ProductException e) {
		  response.sendError(
                  HttpServletResponse.SC_BAD_REQUEST,
                  e.getMessage()
          );
	}
       catch(NumberFormatException e) {
    	   response.sendError(
                   HttpServletResponse.SC_BAD_REQUEST,
                   "Invalid Product ID"
           );
       }
       catch(Exception e) {
    	   throw new ServletException(e);
       }
    }
    
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{
    	String action = request.getParameter("action");
    	if("add".equals(action)) {
    		addProduct(request,response);
    	}
    }
  private void addProduct(
        HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {

    try {

        String categoryIdParam = request.getParameter("categoryId");
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        String priceParam = request.getParameter("price");
        String stockQuantityParam = request.getParameter("stockQuantity");
        String status = request.getParameter("status");
        String imageURL = request.getParameter("imageURL");

        // Validate numeric values
        if (categoryIdParam == null || categoryIdParam.trim().isEmpty()
                || priceParam == null || priceParam.trim().isEmpty()
                || stockQuantityParam == null || stockQuantityParam.trim().isEmpty()) {

            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "Category ID, Price and Stock Quantity are required"
            );
            return;
        }

        int categoryId = Integer.parseInt(categoryIdParam);
        double price = Double.parseDouble(priceParam);
        int stockQuantity = Integer.parseInt(stockQuantityParam);

        Product product = new Product();

        product.setCategoryId(categoryId);
        product.setProductName(productName);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setStatus(status);
       

        productService.addProduct(product);

        // Redirect to correct servlet URL
        response.sendRedirect(
                request.getContextPath() + "/products"
        );

    } catch (ProductException e) {

        response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                e.getMessage()
        );

    } catch (NumberFormatException e) {

        response.sendError(
                HttpServletResponse.SC_BAD_REQUEST,
                "Invalid numeric value"
        );
    }
}

  // Update Product
  private void updateProduct(HttpServletRequest request,HttpServletResponse response) throws IOException {
	  try {
		  String productIdParam =
                  request.getParameter("productId");

          String categoryIdParam =
                  request.getParameter("categoryId");

          String productName =
                  request.getParameter("productName");

          String description =
                  request.getParameter("description");

          String priceParam =
                  request.getParameter("price");

          String stockQuantityParam =
                  request.getParameter("stockQuantity");

          String imageURL =
                  request.getParameter("imageURL");

          String status =
                  request.getParameter("status");
          
          
          if (productIdParam == null
                  || productIdParam.trim().isEmpty()
                  || categoryIdParam == null
                  || categoryIdParam.trim().isEmpty()
                  || priceParam == null
                  || priceParam.trim().isEmpty()
                  || stockQuantityParam == null
                  || stockQuantityParam.trim().isEmpty()) {

              response.sendError(
                      HttpServletResponse.SC_BAD_REQUEST,
                      "Product ID, Category ID, Price and Stock Quantity are required"
              );

              return;
          }
          
          // Convert String to numeric values

          int productId =
                  Integer.parseInt(productIdParam);

          int categoryId =
                  Integer.parseInt(categoryIdParam);

          double price =
                  Double.parseDouble(priceParam);

          int stockQuantity =
                  Integer.parseInt(stockQuantityParam);
          
          // Create Product object

          Product product = new Product();

          product.setProductId(productId);
          product.setCategoryId(categoryId);
          product.setProductName(productName);
          product.setDescription(description);
          product.setPrice(price);
          product.setStockQuantity(stockQuantity);
          product.setImageURL(imageURL);
          product.setStatus(status);


          // Update product

          productService.updateProduct(product);


          // Redirect after successful update

          response.sendRedirect(
                  request.getContextPath()
                  + "/products"
          );
	} catch (ProductException e) {
		response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
	}
	  catch(NumberFormatException e) {
		  response.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid Numeric value");
	  }
	  
  }
}
