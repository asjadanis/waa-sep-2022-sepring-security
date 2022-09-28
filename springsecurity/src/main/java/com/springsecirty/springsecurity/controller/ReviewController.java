package com.springaop.assignment4.controller;

import com.springaop.assignment4.DTOs.ReviewDTO;
import com.springaop.assignment4.aspects.ExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.springaop.assignment4.service.ReviewService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ReviewDTO save(@RequestBody ReviewDTO review) {
        return reviewService.save(review);
    }

    @GetMapping
    public List<ReviewDTO> findAll() {
        return reviewService.findAll();
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public ReviewDTO update(@PathVariable int id, @RequestBody ReviewDTO review) {
        return reviewService.update(id, review);
    }

    @DeleteMapping("/{id}")
    public ReviewDTO delete(@PathVariable int id) {
        return reviewService.delete(id);
    }
}
