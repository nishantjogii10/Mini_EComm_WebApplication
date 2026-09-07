package com.ecommerce.model;

public class OrderItem {
   private int orderItemId;
   private int orderId;
   private Product product;
   private int quantity;
   private int price;
   
   
   public OrderItem() {
	super();
   }


   public OrderItem(int orderItemId, int orderId, Product product, int quantity, int price) {
	super();
	this.orderItemId = orderItemId;
	this.orderId = orderId;
	this.product = product;
	this.quantity = quantity;
	this.price = price;
   }


   public int getOrderItemId() {
	return orderItemId;
   }


   public void setOrderItemId(int orderItemId) {
	this.orderItemId = orderItemId;
   }


   public int getOrderId() {
	return orderId;
   }


   public void setOrderId(int orderId) {
	this.orderId = orderId;
   }


   public Product getProduct() {
	return product;
   }


   public void setProduct(Product product) {
	this.product = product;
   }


   public int getQuantity() {
	return quantity;
   }


   public void setQuantity(int quantity) {
	this.quantity = quantity;
   }


   public int getPrice() {
	return price;
   }


   public void setPrice(int price) {
	this.price = price;
   }
   
   
   public double getSubTotal() {
	   return quantity * price;
   }


   @Override
   public String toString() {
	return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", product=" + product + ", quantity="
			+ quantity + ", price=" + price + "]";
   }
   
}
