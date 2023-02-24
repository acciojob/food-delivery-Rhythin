package com.driver.service.impl;

import com.driver.io.entity.FoodEntity;
import com.driver.io.repository.FoodRepository;
import com.driver.service.FoodService;
import com.driver.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    FoodRepository foodRepository;
    @Override
    public FoodDto createFood(FoodDto food) {
        FoodEntity foodEntity=new FoodEntity();

        String foodId= UUID.randomUUID().toString();

        //foodEntity.setId(food.getId());
        foodEntity.setFoodId(foodId);
        foodEntity.setFoodName(food.getFoodName());
        foodEntity.setFoodPrice(food.getFoodPrice());
        foodEntity.setFoodCategory(food.getFoodCategory());

        foodRepository.save(foodEntity);


        return foodRepository.findByFoodId(foodId).toFoodDto();
    }

    @Override
    public FoodDto getFoodById(String foodId) throws Exception {
        FoodEntity foodEntity=foodRepository.findByFoodId(foodId);

        return foodEntity.toFoodDto();
    }

    @Override
    public FoodDto updateFoodDetails(String foodId, FoodDto foodDetails) throws Exception {

        FoodEntity foodEntity=foodRepository.findByFoodId(foodId);

        foodEntity.setFoodName(foodDetails.getFoodName());
        foodEntity.setFoodPrice(foodDetails.getFoodPrice());
        foodEntity.setFoodCategory(foodDetails.getFoodCategory());

        foodRepository.save(foodEntity);

        return foodEntity.toFoodDto();
    }

    @Override
    public void deleteFoodItem(String id) throws Exception {
        FoodEntity foodEntity= foodRepository.findByFoodId(id);

        foodRepository.delete(foodEntity);

    }

    @Override
    public List<FoodDto> getFoods() {
        List<FoodEntity> foodEntityList=foodRepository.findAll();

        List<FoodDto> foodDtoList=new ArrayList<>();
        for(FoodEntity foodEntity:foodEntityList){

            foodDtoList.add(foodEntity.toFoodDto());
        }

        return foodDtoList;
    }
}