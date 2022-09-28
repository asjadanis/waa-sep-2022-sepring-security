package com.springaop.assignment4.controller;

import com.springaop.assignment4.DTOs.UserDTO;
import com.springaop.assignment4.aspects.ExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.springaop.assignment4.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ExecutionTime
    public UserDTO save(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable int id, @RequestBody UserDTO user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public UserDTO delete(@PathVariable int id) {
        return userService.delete(id);
    }
}
