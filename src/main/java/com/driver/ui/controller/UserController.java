package com.driver.ui.controller;

import java.util.List;

import com.driver.model.request.UserDetailsRequestModel;
import com.driver.model.response.OperationStatusModel;
import com.driver.model.response.RequestOperationName;
import com.driver.model.response.RequestOperationStatus;
import com.driver.model.response.UserResponse;
import com.driver.service.impl.UserServiceImpl;
import com.driver.shared.dto.UserDto;
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
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@GetMapping(path = "/{id}")
	public UserResponse getUser(@PathVariable String id) throws Exception{
		UserResponse userResponse=null;
		try{
			userResponse=userService.getUserByUserId(id).toUserResponse();
		}
		catch (Exception e){

		}
		return userResponse;
	}

	@PostMapping()
	public UserResponse createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception{
		UserResponse userResponse=null;
		try{
			userResponse=userService.createUser(userDetails.toUserDto()).toUserResponse();
		}
		catch (Exception e){

		}
		return userResponse;
	}

	@PutMapping(path = "/{id}")
	public UserResponse updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails) throws Exception{
		UserResponse userResponse=null;
		try{
			userResponse=userService.updateUser(id, userDetails.toUserDto()).toUserResponse();
		}
		catch (Exception e){

		}
		return userResponse;
	}

	@DeleteMapping(path = "/{id}")
	public OperationStatusModel deleteUser(@PathVariable String id) throws Exception{
		OperationStatusModel operationStatusModel=new OperationStatusModel();
		operationStatusModel.setOperationName(RequestOperationName.DELETE.toString());
		operationStatusModel.setOperationResult(RequestOperationStatus.SUCCESS.toString());
		try {
			userService.deleteUser(id);
		}
		catch (Exception e){
			operationStatusModel.setOperationResult(RequestOperationStatus.ERROR.toString());
		}

		return operationStatusModel;
	}
	
	@GetMapping()
	public List<UserResponse> getUsers(){
		List<UserResponse> userResponseList=null;
		try{
			List< UserDto> userDtoList =userService.getUsers();

			for(UserDto userDto:userDtoList){
				userResponseList.add(userDto.toUserResponse());
			}
		}
		catch (Exception e){

		}
		return userResponseList;
	}
	
}
