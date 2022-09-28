package com.springaop.assignment4.controller;

import com.springaop.assignment4.DTOs.AddressDTO;
import com.springaop.assignment4.aspects.ExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.springaop.assignment4.service.AddressService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public AddressDTO save(@RequestBody AddressDTO address) {
        return addressService.save(address);
    }

    @GetMapping
    public List<AddressDTO> findAll() {
        return addressService.findAll();
    }

    @PutMapping("/{id}")
    public AddressDTO update(@PathVariable int id, @RequestBody AddressDTO address) {
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public  AddressDTO delete(@PathVariable int id) {
        return addressService.delete(id);
    }
}
