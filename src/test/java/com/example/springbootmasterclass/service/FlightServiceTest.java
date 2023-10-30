package com.example.springbootmasterclass.service;

import static com.example.springbootmasterclass.common.TestConstant.FLIGHT_NUMBER;
import static org.junit.jupiter.api.Assertions.*;

import com.example.springbootmasterclass.api.model.Flight;
import com.example.springbootmasterclass.common.TestUtil;
import com.example.springbootmasterclass.repository.FlightRepository;
import com.example.springbootmasterclass.repository.entity.FlightEntity;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

  @Mock
  private FlightRepository flightRepository;

  @InjectMocks
  private FlightService flightService;

  @Test
  void shouldFindFlightByName() {

    // Given
    FlightEntity expectedFlight = TestUtil.createFlight();
    Optional<FlightEntity> flight = Optional.of(expectedFlight);
    Mockito.when(flightRepository.findByFlightNumber(FLIGHT_NUMBER)).thenReturn(flight);

    // When
    Flight retrievedFlight = flightService.getFlightByFlightNumber(FLIGHT_NUMBER);

    // Then
    assertNotNull(retrievedFlight, "Flight should not be null");
    assertEquals(expectedFlight.getId(), retrievedFlight.getId(), "IDs should match");
  }

}