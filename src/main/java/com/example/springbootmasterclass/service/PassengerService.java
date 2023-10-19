package com.example.springbootmasterclass.service;

import static com.example.springbootmasterclass.util.Mapper.toPassengerEntity;

import com.example.springbootmasterclass.model.Passenger;
import com.example.springbootmasterclass.repository.PassengerRepository;
import com.example.springbootmasterclass.repository.entity.PassengerEntity;
import com.example.springbootmasterclass.util.Mapper;
import jakarta.persistence.EntityNotFoundException;
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
    passengerRepository.save(toPassengerEntity(passenger));
  }

  public void updatePassenger(Passenger passenger) {
    // Retrieve the existing passenger entity by ID
    PassengerEntity existingPassenger = passengerRepository.findById(passenger.getId())
        .orElseThrow(() -> new EntityNotFoundException("Passenger not found"));

    // Update the existing entity with the new values
    existingPassenger.setName(passenger.getName());
    existingPassenger.setEmail(passenger.getEmail());

    // Save the updated passenger entity back to the database
    passengerRepository.save(existingPassenger);
  }

  public void deletePassenger(Long id) {
    passengerRepository.findById(id).ifPresentOrElse(
        passenger -> {
          passengerRepository.deleteById(id);
        },
        () -> {
          throw new EntityNotFoundException("Passenger with ID " + id + " not found");
        }
    );
  }
}

