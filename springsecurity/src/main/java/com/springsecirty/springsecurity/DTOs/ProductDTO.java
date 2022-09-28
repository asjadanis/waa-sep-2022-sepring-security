package com.springaop.assignment4.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private double rating;
    private CategoryDTO category;
    private List<ReviewDTO> reviews;

}
