package com.example.springbootmasterclass.controller;

import static com.example.springbootmasterclass.constant.ApplicationConstant.BASE_URL;

import com.example.springbootmasterclass.api.model.Flight;
import com.example.springbootmasterclass.service.FlightService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(path = BASE_URL)
public class FlightController {

  private final FlightService flightService;

  @GetMapping
  public ResponseEntity<List<Flight>> getFlights() {
    return ResponseEntity.ok(flightService.getFlights());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Flight> getFlightById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(flightService.getFlight(id));
  }

  @GetMapping("/flightNumber/{flightNumber}")
  public ResponseEntity<Flight> getFlightByFlightNumber(
      @PathVariable("flightNumber") String flightNumber) {
    return ResponseEntity.ok(flightService.getFlightByFlightNumber(flightNumber));
  }

  @PostMapping
  public ResponseEntity<Void> createFlight(@RequestBody Flight flight) {
    flightService.createFlight(flight);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping
  public ResponseEntity<Void> updateFlight(@RequestBody Flight flight) {
    flightService.updateFlight(flight);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{flightId}")
  public ResponseEntity<Void> deletePassenger(@PathVariable("flightId") Long id) {
    flightService.deleteFlight(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
