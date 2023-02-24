package com.driver.model.request;

import com.driver.shared.dto.FoodDto;

public class FoodDetailsRequestModel {

	private String foodName;
	private String foodCategory;
	private float foodPrice;
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

	public FoodDto toFoodDto(){
		FoodDto foodDto=new FoodDto();

		foodDto.setFoodName(foodName);
		foodDto.setFoodCategory(foodCategory);
		foodDto.setFoodPrice(foodPrice);

		return foodDto;
	}
}
