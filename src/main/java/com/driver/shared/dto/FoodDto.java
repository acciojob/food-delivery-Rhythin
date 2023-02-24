package com.driver.shared.dto;

import com.driver.model.response.FoodDetailsResponse;

import java.io.Serializable;

public class FoodDto{

	private long id;
	private String foodId;
	private String foodName;
	private String foodCategory;
	private float foodPrice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFoodId() {
		return foodId;
	}

	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public float getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(float foodPrice) {
		this.foodPrice = foodPrice;
	}

	public FoodDetailsResponse toFoodDetailsResponse(){
		FoodDetailsResponse foodDetailsResponse=new FoodDetailsResponse();

		foodDetailsResponse.setFoodId(foodId);
		foodDetailsResponse.setFoodName(foodName);
		foodDetailsResponse.setFoodPrice(foodPrice);
		foodDetailsResponse.setFoodCategory(foodCategory);

		return foodDetailsResponse;
	}

}
