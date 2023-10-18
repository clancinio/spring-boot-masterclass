package com.example.springbootmasterclass.service;

import com.example.springbootmasterclass.model.Passenger;
import com.example.springbootmasterclass.repository.PassengerRepository;
import com.example.springbootmasterclass.repository.entity.PassengerEntity;
import com.example.springbootmasterclass.util.Mapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassengerService {

  private final PassengerRepository passengerRepository;

  public List<Passenger> getPassengers() {
    List<PassengerEntity> passengerEntities = passengerRepository.findAll();
    return passengerEntities.stream()
        .map(Mapper::toPassenger)
        .toList();
  }

  public void createPassenger(Passenger passenger) {
    System.out.println("Creating passenger: " + passenger);
  }

  public void updatePassenger(Passenger passenger) {
    System.out.println("Updating passenger: " + passenger);
  }

  public void deletePassenger(Long id) {
    System.out.println("Deleting passenger with id: " + id);
  }

}
