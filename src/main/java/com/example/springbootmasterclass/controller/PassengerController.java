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
  List<Passenger> getPassengers() {
    return passengerService.getPassengers();
  }

  @PostMapping
  void createPassenger(@RequestBody Passenger passenger) {
    passengerService.createPassenger(passenger);
  }

  @PutMapping
  void deleteCustomer(@RequestBody Passenger passenger) {
    passengerService.updatePassenger(passenger);
  }

  @DeleteMapping(path = "/{customerId}")
  void deleteCustomer(@PathVariable("customerId") Long id) {
    passengerService.deletePassenger(id);
  }
}
