package com.example.springbootmasterclass.controller;

import com.example.springbootmasterclass.model.Passenger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerController {

  @GetMapping
  Passenger getPassenger(){
    return Passenger.builder()
        .id(123L)
        .name("John Doe")
        .build();
  }
}
