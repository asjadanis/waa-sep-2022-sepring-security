package com.springaop.assignment4.service;

import com.springaop.assignment4.DTOs.AddressDTO;

import java.util.List;

public interface AddressService {
    AddressDTO save (AddressDTO address);
    List<AddressDTO> findAll();
    AddressDTO findOne(int id);
    AddressDTO update(int id, AddressDTO address);
    AddressDTO delete(int id);
}
