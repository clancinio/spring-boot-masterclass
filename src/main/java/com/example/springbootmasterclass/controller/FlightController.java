package com.example.springbootmasterclass.controller;

import com.example.springbootmasterclass.api.model.Flight;
import com.example.springbootmasterclass.service.FlightService;
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
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/flights")
public class FlightController {

  private final FlightService flightService;

  @GetMapping
  public List<Flight> getFlights() {
    return flightService.getFlights();
  }

  @GetMapping("/{id}")
  public Flight getFlightById(@PathVariable("id") Long id) {
    return flightService.getFlight(id);
  }

  @PostMapping
  public void createFlight(@RequestBody Flight flight) {
    flightService.createFlight(flight);
  }

  @PutMapping
  public void updateFlight(@RequestBody Flight flight) {
    flightService.updateFlight(flight);
  }

  @DeleteMapping("/{flightId}")
  public void deletePassenger(@PathVariable("flightId") Long id) {
    flightService.deleteFlight(id);
  }
}

