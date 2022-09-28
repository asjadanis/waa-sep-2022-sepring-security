package com.springaop.assignment4.service.impl;

import com.springaop.assignment4.DTOs.ProductDTO;
import com.springaop.assignment4.models.Product;
import com.springaop.assignment4.repository.ProductRepo;
import com.springaop.assignment4.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {

    @Autowired
    private final ProductRepo productRepo;
    private final ModelMapper mapper;

    @Override
    public ProductDTO save(ProductDTO product) {
        Product mappedProduct = mapper.map(product, Product.class);
        return mapper.map(productRepo.save(mappedProduct), ProductDTO.class);
    }

    @Override
    public List<ProductDTO> findAll() {
        List<ProductDTO> products = new ArrayList<>();
        productRepo.findAll().forEach(product -> products.add(mapper.map(product, ProductDTO.class)));
        return products;
    }

    @Override
    public ProductDTO findOne(int id) {
        return mapper.map(productRepo.findById(id), ProductDTO.class);
    }

    @Override
    public ProductDTO update(int id, ProductDTO product) {
        Product mappedProduct = mapper.map(product, Product.class);
        Product updatedProduct = productRepo.save(mappedProduct);
        return mapper.map(updatedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO delete(int id) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("ID is invalid!!!"));
        return mapper.map(product, ProductDTO.class);
    }
}
