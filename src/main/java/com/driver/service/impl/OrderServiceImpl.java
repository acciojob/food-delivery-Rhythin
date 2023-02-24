package com.driver.service.impl;

import com.driver.io.entity.OrderEntity;
import com.driver.io.entity.UserEntity;
import com.driver.io.repository.OrderRepository;
import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;
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
public class OrderServiceImpl implements OrderService {

    //@Autowired
    OrderRepository orderRepository=new OrderRepository() {
        @Override
        public OrderEntity findByOrderId(String orderId) {
            return null;
        }

        @Override
        public List<OrderEntity> findAll() {
            return null;
        }

        @Override
        public List<OrderEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<OrderEntity> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends OrderEntity> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends OrderEntity> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<OrderEntity> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public OrderEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends OrderEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends OrderEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<OrderEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends OrderEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<OrderEntity> findById(Long aLong) {
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
        public void delete(OrderEntity orderEntity) {

        }

        @Override
        public void deleteAll(Iterable<? extends OrderEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends OrderEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends OrderEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends OrderEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends OrderEntity> boolean exists(Example<S> example) {
            return false;
        }
    };
    @Override
    public OrderDto createOrder(OrderDto order) {
        OrderEntity orderEntity=new OrderEntity();

        orderEntity.setItems(order.getItems());
        orderEntity.setCost(order.getCost());
        orderEntity.setUserId(order.getUserId());

        String orderId= UUID.randomUUID().toString();
        orderEntity.setOrderId(orderId);

        orderRepository.save(orderEntity);

        return orderRepository.findByOrderId(orderId).toOderDto();
    }

    @Override
    public OrderDto getOrderById(String orderId) throws Exception {
        return orderRepository.findByOrderId(orderId).toOderDto();
    }

    @Override
    public OrderDto updateOrderDetails(String orderId, OrderDto order) throws Exception {
        OrderEntity orderEntity=orderRepository.findByOrderId(orderId);

        orderEntity.setItems(order.getItems());
        orderEntity.setCost(order.getCost());
        orderEntity.setUserId(order.getUserId());

        orderRepository.save(orderEntity);

        return orderEntity.toOderDto();
    }

    @Override
    public void deleteOrder(String orderId) throws Exception {
        OrderEntity orderEntity=orderRepository.findByOrderId(orderId);
        orderRepository.delete(orderEntity);
    }

    @Override
    public List<OrderDto> getOrders() {
        List<OrderDto> orderDtoList=new ArrayList<>();

        List<OrderEntity> orderEntityList=orderRepository.findAll();

        for(OrderEntity orderEntity:orderEntityList){
            orderDtoList.add(orderEntity.toOderDto());
        }
        return orderDtoList;
    }
}