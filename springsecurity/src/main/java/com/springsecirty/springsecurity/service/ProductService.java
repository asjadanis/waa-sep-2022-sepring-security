package com.springaop.assignment4.service;

import com.springaop.assignment4.DTOs.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save (ProductDTO address);
    List<ProductDTO> findAll();
    ProductDTO findOne(int id);
    ProductDTO update(int id, ProductDTO address);
    ProductDTO delete(int id);
}
