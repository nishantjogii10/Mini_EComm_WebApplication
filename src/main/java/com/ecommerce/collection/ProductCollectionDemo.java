package com.ecommerce.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ecommerce.model.Product;

public class ProductCollectionDemo {

    // Search Product by name or description
    public static Product searchByName(List<Product> products, String searchText) {

        for (Product product : products) {

            if (product.getProductName().toLowerCase().contains(searchText.toLowerCase())
                    || product.getDescription().toLowerCase().contains(searchText.toLowerCase())) {

                return product;
            }
        }

        return null;
    }

    // Filter Products by Category
    public static List<Product> filterByCategory(
            List<Product> products, int categoryId) {

        List<Product> result = new ArrayList<>();

        for (Product product : products) {

            if (product.getCategoryId() == categoryId) {
                result.add(product);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Create Product List
        List<Product> products = new ArrayList<Product>();

        // Product 1
        Product p1 = new Product();

        p1.setProductId(1);
        p1.setCategoryId(3);
        p1.setProductName("Dell Insprion 15");
        p1.setDescription("15-inch laptop");
        p1.setPrice(58000.00);
        p1.setStockQuantity(20);
        p1.setStatus("ACTIVE");

        // Product 2
        Product p2 = new Product();

        p2.setProductId(2);
        p2.setCategoryId(3);
        p2.setProductName("Hp Insprion 15");
        p2.setDescription("15-inch laptop");
        p2.setPrice(52000.00);
        p2.setStockQuantity(9);
        p2.setStatus("ACTIVE");

        // Product 3
        Product p3 = new Product();

        p3.setProductId(3);
        p3.setCategoryId(2);
        p3.setProductName("Samsung");
        p3.setDescription("SmartPhone");
        p3.setPrice(16000.00);
        p3.setStockQuantity(10);
        p3.setStatus("ACTIVE");

        // Product 4
        Product p4 = new Product();

        p4.setProductId(4);
        p4.setCategoryId(2);
        p4.setProductName("iPhone 15");
        p4.setDescription("Apple Smartphone");
        p4.setPrice(58000.00);
        p4.setStockQuantity(20);
        p4.setStatus("ACTIVE");

        // Add products to ArrayList
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);

        // Display Product List
        System.out.println("------- Product List -------");

        for (Product product : products) {

            System.out.println(
                    product.getProductId()
                    + " | "
                    + product.getProductName()
                    + " | Rs. "
                    + product.getPrice()
            );
        }

        // ------------------------------------------------
        // Search Product
        // ------------------------------------------------

        Product result = searchByName(products, "laptop");

        if (result != null) {

            System.out.println(
                    "\nProduct Found : "
                    + result.getProductName()
            );

        } else {

            System.out.println("\nProduct Not Found!");
        }

        // ------------------------------------------------
        // Filter Products by Category
        // ------------------------------------------------

        List<Product> laptopProducts = filterByCategory(products, 3);

        System.out.println("\n-------- Laptops --------");

        for (Product product : laptopProducts) {

            System.out.println(
                    product.getProductName()
                    + " | Rs. "
                    + product.getPrice()
            );
        }

        // ------------------------------------------------
        // Sort Products by Name
        // ------------------------------------------------

        Collections.sort(products);

        System.out.println("\n----- Sorted By Name -----");

        for (Product product : products) {

            System.out.println(product.getProductName());
        }

        // ------------------------------------------------
        // Sort Price Low to High
        // ------------------------------------------------

        products.sort(
                Comparator.comparingDouble(Product::getPrice)
        );

        System.out.println("\n---- Low to High ----");

        for (Product product : products) {

            System.out.println(
                    product.getProductName()
                    + " | Rs. "
                    + product.getPrice()
            );
        }

        // ------------------------------------------------
        // Sort Price High to Low
        // ------------------------------------------------

        products.sort(
                Comparator.comparingDouble(Product::getPrice).reversed()
        );

        System.out.println("\n------ High to Low ------");

        for (Product product : products) {

            System.out.println(
                    product.getProductName()
                    + " | Rs. "
                    + product.getPrice()
            );
        }

        // ------------------------------------------------
        // HashMap : Product Lookup
        // ------------------------------------------------

        Map<Integer, Product> productMap = new HashMap<>();

        // Add Products to HashMap
        for (Product product : products) {

            productMap.put(
                    product.getProductId(),
                    product
            );
        }

        // Find Product by Product ID
        Product product = productMap.get(3);

      //  if (product != null) {

            System.out.println(
                    "\nProduct Id 3 : "
                    + product.getProductName());
         //

       // } else {

           // System.out.println("\nProduct Not Found!");
       // }
    }
}