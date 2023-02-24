package com.driver.ui.controller;

import java.util.List;

import com.driver.model.request.OrderDetailsRequestModel;
import com.driver.model.response.OperationStatusModel;
import com.driver.model.response.OrderDetailsResponse;
import com.driver.model.response.RequestOperationName;
import com.driver.model.response.RequestOperationStatus;
import com.driver.service.impl.OrderServiceImpl;
import com.driver.shared.dto.OrderDto;
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
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderServiceImpl orderService;
	@GetMapping(path="/{id}")
	public OrderDetailsResponse getOrder(@PathVariable String id) throws Exception{
		OrderDetailsResponse orderDetailsResponse=null;
		try {
			orderDetailsResponse=orderService.getOrderById(id).toOrderDetailsResponse();
		}
		catch (Exception e){

		}

		return orderDetailsResponse;
	}
	
	@PostMapping()
	public OrderDetailsResponse createOrder(@RequestBody OrderDetailsRequestModel order) {
		OrderDetailsResponse orderDetailsResponse=null;
		try {
			orderDetailsResponse=orderService.createOrder(order.toOrderDto()).toOrderDetailsResponse();
		}
		catch (Exception e){

		}

		return orderDetailsResponse;
	}
		
	@PutMapping(path="/{id}")
	public OrderDetailsResponse updateOrder(@PathVariable String id, @RequestBody OrderDetailsRequestModel order) throws Exception{
		OrderDetailsResponse orderDetailsResponse=null;
		try {
			orderDetailsResponse=orderService.updateOrderDetails(id, order.toOrderDto()).toOrderDetailsResponse();
		}
		catch (Exception e){

		}

		return orderDetailsResponse;
	}
	
	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteOrder(@PathVariable String id) throws Exception {
		OperationStatusModel operationStatusModel=new OperationStatusModel();
		operationStatusModel.setOperationName(RequestOperationName.DELETE.toString());
		operationStatusModel.setOperationResult(RequestOperationStatus.SUCCESS.toString());
		try {
			orderService.deleteOrder(id);
		}
		catch (Exception e){
			operationStatusModel.setOperationResult(RequestOperationStatus.ERROR.toString());
		}

		return operationStatusModel;
	}
	
	@GetMapping()
	public List<OrderDetailsResponse> getOrders() {
		List<OrderDetailsResponse> orderDetailsResponseList=null;
		try {
			List<OrderDto> orderDtoList =orderService.getOrders();

			for(OrderDto orderDto:orderDtoList){
				orderDetailsResponseList.add(orderDto.toOrderDetailsResponse());
			}
		}
		catch (Exception e){

		}

		return orderDetailsResponseList;
	}
}
