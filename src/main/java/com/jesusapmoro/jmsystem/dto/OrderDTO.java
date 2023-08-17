package com.jesusapmoro.jmsystem.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.jesusapmoro.jmsystem.entities.Order;

public class OrderDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant moment;
	private Integer orderStatus;
	private UserDTO client;
	private List<OrderItemDTO> items = new ArrayList<>();
	private Double getTotal;
	
	public OrderDTO() {
	}
	
	public OrderDTO(Order obj) {
		id = obj.getId();
		moment = obj.getMoment();
		orderStatus = obj.getOrderStatus().getCode();
		client = new UserDTO(obj.getClient());
		obj.getItems().forEach(item -> this.items.add(new OrderItemDTO(item)));
		getTotal = obj.getTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public UserDTO getClient() {
		return client;
	}

	public void setClient(UserDTO client) {
		this.client = client;
	}

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}

	public Double getGetTotal() {
		return getTotal;
	}
	
}
