package com.driver.model.request;

import com.driver.shared.dto.OrderDto;
import org.hibernate.criterion.Order;

public class OrderDetailsRequestModel {

	private String[] items;
	private float cost;
	private String userId;
	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public OrderDto toOrderDto(){
		OrderDto orderDto=new OrderDto();

		orderDto.setItems(items);
		orderDto.setCost(cost);
		orderDto.setUserId(userId);

		return orderDto;
	}

}
