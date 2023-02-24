package com.driver.service.impl;

import com.driver.io.entity.UserEntity;
import com.driver.io.repository.UserRepository;
import com.driver.service.UserService;
import com.driver.shared.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService{

    //@Autowired
    UserRepository userRepository=new UserRepository() {
        @Override
        public UserEntity findByEmail(String email) {
            return null;
        }

        @Override
        public UserEntity findByUserId(String userId) {
            return null;
        }

        @Override
        public List<UserEntity> findAll() {
            return null;
        }

        @Override
        public List<UserEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<UserEntity> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends UserEntity> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<UserEntity> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public UserEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<UserEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<UserEntity> findById(Long aLong) {
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
        public void delete(UserEntity userEntity) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends UserEntity> boolean exists(Example<S> example) {
            return false;
        }
    };
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