package com.springaop.assignment4.service.impl;

import com.springaop.assignment4.DTOs.AddressDTO;
import com.springaop.assignment4.models.Address;
import com.springaop.assignment4.repository.AddressRepo;
import com.springaop.assignment4.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService {

    @Autowired
    private AddressRepo addressRepo;
    private final ModelMapper mapper;

    @Override
    public AddressDTO save(AddressDTO address) {
        Address mappedAddress = mapper.map(address, Address.class);
        return mapper.map(addressRepo.save(mappedAddress), AddressDTO.class);
    }

    @Override
    public List<AddressDTO> findAll() {
        List<AddressDTO> mappedAddresses = new ArrayList<>();
        addressRepo.findAll().forEach(address -> mappedAddresses.add(mapper.map(address, AddressDTO.class)));
        return mappedAddresses;
    }

    @Override
    public AddressDTO findOne(int id) {
        return mapper.map(addressRepo.findById(id), AddressDTO.class) ;
    }

    @Override
    public AddressDTO update(int id, AddressDTO address) {
        Address mappedAddress = mapper.map(address, Address.class);
        Address updatedAddress = addressRepo.save(mappedAddress);
        return mapper.map(updatedAddress, AddressDTO.class);
    }

    @Override
    public AddressDTO delete(int id) {

        Address address = addressRepo.findById(id).orElseThrow(() -> new RuntimeException("ID is not Valid"));
        addressRepo.delete(address);
        return mapper.map(address, AddressDTO.class);
    }
}
