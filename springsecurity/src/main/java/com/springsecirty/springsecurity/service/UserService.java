package com.springaop.assignment4.service;

import com.springaop.assignment4.DTOs.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save (UserDTO address);
    List<UserDTO> findAll();
    UserDTO findOne(int id);
    UserDTO update(int id, UserDTO address);
    UserDTO delete(int id);
}
