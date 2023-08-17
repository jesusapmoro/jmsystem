package com.jesusapmoro.jmsystem.dto;

import java.io.Serializable;

import com.jesusapmoro.jmsystem.entities.Order;
import com.jesusapmoro.jmsystem.entities.OrderItem;
import com.jesusapmoro.jmsystem.entities.Product;

public class OrderItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Order order;
	private Product product;
	private Integer quantity;
	private Double price;
	public Double subtotal;
	
	public OrderItemDTO() {
	}
	
	public OrderItemDTO(OrderItem obj) {
		order = obj.getOrder();
		product = obj.getProduct();
		quantity = obj.getQuantity();
		price = obj.getPrice();
		subtotal = obj.getSubTotal();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubtotal() {
		return subtotal;
	}
	
}
