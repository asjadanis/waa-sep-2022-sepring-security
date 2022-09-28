package com.springaop.assignment4.service;

import com.springaop.assignment4.DTOs.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO save (ReviewDTO address);
    List<ReviewDTO> findAll();
    ReviewDTO findOne(int id);
    ReviewDTO update(int id, ReviewDTO address);
    ReviewDTO delete(int id);
}
