package com.example.springbootmasterclass.controller;

import com.example.springbootmasterclass.model.Passenger;
import com.example.springbootmasterclass.service.PassengerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/customers")
@RequiredArgsConstructor
public class PassengerController {

  private final PassengerService passengerService;

  @GetMapping
  public List<Passenger> getPassengers() {
    return passengerService.getPassengers();
  }

  @PostMapping
  public void createPassenger(@RequestBody Passenger passenger) {
    passengerService.createPassenger(passenger);
  }

  @PutMapping
  public void updatePassenger(@RequestBody Passenger passenger) {
    passengerService.updatePassenger(passenger);
  }

  @DeleteMapping("/{customerId}")
  public void deletePassenger(@PathVariable("customerId") Long id) {
    passengerService.deletePassenger(id);
  }
}

