package com.example.springbootmasterclass.service;

import com.example.springbootmasterclass.model.Passenger;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

  public List<Passenger> getPassengers() {
    return Arrays.asList(Passenger.builder()
            .id(123L)
            .name("John Doe")
            .build(),
        Passenger.builder()
            .id(124L)
            .name("Benny Boe")
            .build());
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
