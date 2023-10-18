package com.example.springbootmasterclass.service;

import com.example.springbootmasterclass.model.Passenger;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

  public Passenger getPassenger() {
    return Passenger.builder()
        .id(123L)
        .name("John Doe")
        .build();
  }

  public void createPassenger(Passenger passenger) {
    System.out.println("Creating passenger: " + passenger);
  }

  public void updatePassenger(Passenger passenger) {
    System.out.println("Updating passenger: " + passenger);
  }

  public void deletePassenger(Long id) {
    System.out.println("Deleting passenger with id: " + id);
  }

}
