package com.springaop.assignment4.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private int id;
    private String street;
    private String zip;
    private String city;
}
