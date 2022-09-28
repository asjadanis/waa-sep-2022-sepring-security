package com.springaop.assignment4.service.impl;

import com.springaop.assignment4.DTOs.UserDTO;
import com.springaop.assignment4.models.User;
import com.springaop.assignment4.repository.UserRepo;
import com.springaop.assignment4.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;
    private final ModelMapper mapper;

    @Override
    public UserDTO save(UserDTO user) {
        User mappedUser = mapper.map(user, User.class);
        return mapper.map(userRepo.save(mappedUser), UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();
        userRepo.findAll().forEach(user -> users.add(mapper.map(user, UserDTO.class)));
        return users;
    }

    @Override
    public UserDTO findOne(int id) {
        return mapper.map(userRepo.findById(id), UserDTO.class);
    }

    @Override
    public UserDTO update(int id, UserDTO user) {
        User mappedUser = mapper.map(user, User.class);
        User updatedUser = userRepo.save(mappedUser);
        return mapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public UserDTO delete(int id) {
        User user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("ID is not valid !!!"));
        return mapper.map(user, UserDTO.class);
    }
}
