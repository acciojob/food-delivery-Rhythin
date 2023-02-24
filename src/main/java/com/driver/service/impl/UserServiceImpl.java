package com.driver.service.impl;

import com.driver.io.entity.UserEntity;
import com.driver.io.repository.UserRepository;
import com.driver.service.UserService;
import com.driver.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto user) throws Exception {
        UserEntity userEntity=new UserEntity();

        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());

        String userId= UUID.randomUUID().toString();
        userEntity.setUserId(userId);

        userRepository.save(userEntity);

        return userRepository.findByUserId(userId).toUserDto();
    }

    @Override
    public UserDto getUser(String email) throws Exception {
        return userRepository.findByEmail(email).toUserDto();
    }

    @Override
    public UserDto getUserByUserId(String userId) throws Exception {
        return userRepository.findByUserId(userId).toUserDto();
    }

    @Override
    public UserDto updateUser(String userId, UserDto user) throws Exception {
        UserEntity userEntity=userRepository.findByUserId(userId);

        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());

        userRepository.save(userEntity);

        return userRepository.findByUserId(userId).toUserDto();
    }

    @Override
    public void deleteUser(String userId) throws Exception {

        UserEntity userEntity=userRepository.findByUserId(userId);
        userRepository.delete(userEntity);
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> userDtoList=new ArrayList<>();
        List<UserEntity> userEntityList=userRepository.findAll();

        for(UserEntity userEntity:userEntityList){
            userDtoList.add(userEntity.toUserDto());
        }
        return userDtoList;
    }
}