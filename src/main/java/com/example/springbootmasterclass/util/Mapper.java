package com.example.springbootmasterclass.util;

import com.example.springbootmasterclass.api.model.Flight;
import com.example.springbootmasterclass.repository.entity.FlightEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Mapper {

  public static Flight toFlight(FlightEntity entity) {
    return Flight.builder()
        .id(entity.getId())
        .flightNumber(entity.getFlightNumber())
        .departureDate(entity.getDepartureDate())
        .departureTime(entity.getDepartureTime())
        .build();
  }

  public static FlightEntity toFlightEntity(Flight flight) {
    return FlightEntity.builder()
        .flightNumber(flight.getFlightNumber())
        .departureDate(flight.getDepartureDate())
        .departureTime(flight.getDepartureTime())
        .build();
  }
}
