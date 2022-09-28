package com.springaop.assignment4.service.impl;

import com.springaop.assignment4.DTOs.ReviewDTO;
import com.springaop.assignment4.models.Review;
import com.springaop.assignment4.repository.ReviewRepo;
import com.springaop.assignment4.service.ReviewService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;
    private final ModelMapper mapper;

    @Override
    public ReviewDTO save(ReviewDTO review) {
        Review mappedReview = mapper.map(review, Review.class);
        return mapper.map(reviewRepo.save(mappedReview), ReviewDTO.class);
    }

    @Override
    public List<ReviewDTO> findAll() {
       List<ReviewDTO> reviews = new ArrayList<>();
       reviewRepo.findAll().forEach(review -> reviews.add(mapper.map(review, ReviewDTO.class)));
       return reviews;
    }

    @Override
    public ReviewDTO findOne(int id) {
        return mapper.map(reviewRepo.findById(id), ReviewDTO.class);
    }

    @Override
    public ReviewDTO update(int id, ReviewDTO review) {
        Review mappedReview = mapper.map(review, Review.class);
        Review updatedReview = reviewRepo.save(mappedReview);
        return mapper.map(updatedReview, ReviewDTO.class);
    }

    @Override
    public ReviewDTO delete(int id) {
       Review review = reviewRepo.findById(id).orElseThrow(() -> new RuntimeException("ID is not valid !!!"));
       return mapper.map(review, ReviewDTO.class);
    }
}
