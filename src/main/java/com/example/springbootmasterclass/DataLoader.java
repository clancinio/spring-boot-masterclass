package com.example.springbootmasterclass;

import com.example.springbootmasterclass.model.Passenger;
import com.example.springbootmasterclass.repository.PassengerRepository;
import com.example.springbootmasterclass.repository.entity.PassengerEntity;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final PassengerRepository passengerRepository;

  @Override
  public void run(String... args) throws Exception {
    List<PassengerEntity> examplePassengers = createExamplePassengers();
    passengerRepository.saveAll(examplePassengers);
  }

  private List<PassengerEntity> createExamplePassengers() {
    List<PassengerEntity> passengers = new ArrayList<>();

    for (int i = 1; i <= 20; i++) {
      passengers.add(PassengerEntity.builder()
          .name("Passenger " + i)
          .email("passenger" + i + "@example.com")
          .build());
    }
    return passengers;
  }
}

