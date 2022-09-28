package com.springaop.assignment4.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private List<ReviewDTO> reviews;
    private AddressDTO address;
}
