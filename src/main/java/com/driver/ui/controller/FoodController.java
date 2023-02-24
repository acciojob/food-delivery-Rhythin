package com.driver.ui.controller;

import java.util.ArrayList;
import java.util.List;

import com.driver.model.request.FoodDetailsRequestModel;
import com.driver.model.response.FoodDetailsResponse;
import com.driver.model.response.OperationStatusModel;
import com.driver.model.response.RequestOperationName;
import com.driver.model.response.RequestOperationStatus;
import com.driver.service.impl.FoodServiceImpl;
import com.driver.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foods")
public class FoodController {

	@Autowired
	FoodServiceImpl foodService;

	@GetMapping(path="/{id}")
	public FoodDetailsResponse getFood(@PathVariable String id) throws Exception{
		FoodDetailsResponse foodDetailsResponse=null;
		try {
			foodDetailsResponse=foodService.getFoodById(id).toFoodDetailsResponse();
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
		return foodDetailsResponse;
	}

	@PostMapping("/create")
	public FoodDetailsResponse createFood(@RequestBody FoodDetailsRequestModel foodDetails) {

		FoodDetailsResponse foodDetailsResponse=foodService.createFood(foodDetails.toFoodDto()).toFoodDetailsResponse();

		return foodDetailsResponse;
	}

	@PutMapping(path="/{id}")
	public FoodDetailsResponse updateFood(@PathVariable String id, @RequestBody FoodDetailsRequestModel foodDetails) throws Exception{
		FoodDetailsResponse foodDetailsResponse;
		try {
			foodDetailsResponse= foodService.updateFoodDetails(id, foodDetails.toFoodDto()).toFoodDetailsResponse();
		}
		catch (Exception e){
			return null;
		}

		return foodDetailsResponse;
	}

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteFood(@PathVariable String id) throws Exception{
		OperationStatusModel operationStatusModel=new OperationStatusModel();
		operationStatusModel.setOperationName(RequestOperationName.DELETE.toString());
		operationStatusModel.setOperationResult(RequestOperationStatus.SUCCESS.toString());
		try {
			foodService.deleteFoodItem(id);
		}
		catch (Exception e){
			operationStatusModel.setOperationResult(RequestOperationStatus.ERROR.toString());
		}

		return operationStatusModel;
	}
	
	@GetMapping()
	public List<FoodDetailsResponse> getFoods() {
		List<FoodDto> foodDtoList=foodService.getFoods();

		List<FoodDetailsResponse> foodDetailsResponseList=new ArrayList<>();
		for (FoodDto foodDto:foodDtoList) {
			foodDetailsResponseList.add(foodDto.toFoodDetailsResponse());
		}
		return foodDetailsResponseList;
	}
}
