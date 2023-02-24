package com.driver.service.impl;

import com.driver.io.entity.OrderEntity;
import com.driver.io.entity.UserEntity;
import com.driver.io.repository.OrderRepository;
import com.driver.service.OrderService;
import com.driver.shared.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
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