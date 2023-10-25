package com.example.springbootmasterclass;

import com.example.springbootmasterclass.repository.FlightRepository;
import com.example.springbootmasterclass.repository.entity.FlightEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final FlightRepository flightRepository;

  @Override
  public void run(String... args) throws Exception {
    List<FlightEntity> examplePassengers = createExampleFlights();
    flightRepository.saveAll(examplePassengers);
  }

  private List<FlightEntity> createExampleFlights() {
    List<FlightEntity> flightEntities = new ArrayList<>();

    for (int i = 2000; i < 2005; i++) {
      flightEntities.add(FlightEntity.builder()
          .flightNumber("CL" + i)
          .departureDate("27-10-2023")
          .departureTime("07::45")
          .build());
    }
    return flightEntities;
  }
}

