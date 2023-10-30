package com.example.springbootmasterclass.common;

import static com.example.springbootmasterclass.common.TestConstant.DEPARTURE_DATE;
import static com.example.springbootmasterclass.common.TestConstant.DEPARTURE_TIME;
import static com.example.springbootmasterclass.common.TestConstant.FLIGHT_NUMBER;

import com.example.springbootmasterclass.api.model.Flight;
import com.example.springbootmasterclass.repository.entity.FlightEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestUtil {

  public static FlightEntity createFlight() {
    return FlightEntity.builder()
        .flightNumber(FLIGHT_NUMBER)
        .departureDate(DEPARTURE_DATE)
        .departureTime(DEPARTURE_TIME)
        .build();
  }
}
