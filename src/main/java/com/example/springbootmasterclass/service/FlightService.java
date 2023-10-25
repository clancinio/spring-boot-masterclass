package com.example.springbootmasterclass.service;

import static com.example.springbootmasterclass.constant.ErrorConstant.Message.NOT_FOUND;
import static com.example.springbootmasterclass.util.Mapper.toFlightEntity;

import com.example.springbootmasterclass.api.model.Flight;
import com.example.springbootmasterclass.exception.NotFoundException;
import com.example.springbootmasterclass.repository.FlightRepository;
import com.example.springbootmasterclass.repository.entity.FlightEntity;
import com.example.springbootmasterclass.util.Mapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FlightService {

  private final FlightRepository flightRepository;

  public List<Flight> getFlights() {
    List<FlightEntity> flightEntities = flightRepository.findAll();
    return flightEntities.stream()
        .map(Mapper::toFlight)
        .toList();
  }

  public void createFlight(Flight passenger) {
    flightRepository.save(toFlightEntity(passenger));
  }

  public void updateFlight(Flight flight) {
    // Retrieve the existing passenger entity by ID
    FlightEntity existingFlight = flightRepository.findById(flight.getId())
        .orElseThrow(() -> new NotFoundException(NOT_FOUND,
            String.format("Flight with id %s not found", flight.getId())));

    // Update the existing entity with the new values
    existingFlight.setFlightNumber(flight.getFlightNumber());
    existingFlight.setDepartureDate(flight.getDepartureDate());
    existingFlight.setDepartureTime(flight.getDepartureTime());

    // Save the updated flight entity back to the database
    flightRepository.save(existingFlight);
  }

  public void deleteFlight(Long id) {
    flightRepository.findById(id).ifPresentOrElse(
        passenger -> {
          flightRepository.deleteById(id);
        },
        () -> {
          throw new NotFoundException(NOT_FOUND,
              String.format("Flight with id %s not found", id));
        }
    );
  }
}

