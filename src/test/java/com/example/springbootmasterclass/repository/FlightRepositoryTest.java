package com.example.springbootmasterclass.repository;

import static com.example.springbootmasterclass.common.TestConstant.FLIGHT_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.springbootmasterclass.common.TestUtil;
import com.example.springbootmasterclass.repository.entity.FlightEntity;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class FlightRepositoryTest {

  @Autowired
  private FlightRepository flightRepository;

  @Autowired
  private TestEntityManager entityManager;


  @Test
  void shouldFindFlightByFlightNumber(){

    // Given
    FlightEntity flightEntity = TestUtil.createFlightEntity();
    entityManager.persist(flightEntity);

    // When
    Optional<FlightEntity> retrievedFlight = flightRepository.findByFlightNumber(FLIGHT_NUMBER);

    // Then
    assertTrue(retrievedFlight.isPresent());
    assertEquals(FLIGHT_NUMBER, retrievedFlight.get().getFlightNumber());
  }
}
