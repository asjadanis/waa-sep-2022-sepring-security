package com.springaop.assignment4.controller;

import com.springaop.assignment4.DTOs.ProductDTO;
import com.springaop.assignment4.aspects.ExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.springaop.assignment4.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ExecutionTime
    public ProductDTO save(@RequestBody ProductDTO product) {
        return productService.save(product);
    }

    @GetMapping
    @ExecutionTime
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable int id, @RequestBody ProductDTO product) {
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public ProductDTO delete(@PathVariable int id) {
        return productService.delete(id);
    }
}
