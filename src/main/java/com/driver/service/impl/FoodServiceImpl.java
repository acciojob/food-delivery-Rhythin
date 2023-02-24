package com.driver.service.impl;

import com.driver.io.entity.FoodEntity;
import com.driver.io.repository.FoodRepository;
import com.driver.service.FoodService;
import com.driver.shared.dto.FoodDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoodServiceImpl implements FoodService {

    //@Autowired
    FoodRepository foodRepository=new FoodRepository() {
        @Override
        public FoodEntity findByFoodId(String foodId) {
            return null;
        }

        @Override
        public List<FoodEntity> findAll() {
            return null;
        }

        @Override
        public List<FoodEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<FoodEntity> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends FoodEntity> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends FoodEntity> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<FoodEntity> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public FoodEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends FoodEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends FoodEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<FoodEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends FoodEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<FoodEntity> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(FoodEntity foodEntity) {

        }

        @Override
        public void deleteAll(Iterable<? extends FoodEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends FoodEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends FoodEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends FoodEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends FoodEntity> boolean exists(Example<S> example) {
            return false;
        }
    };
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