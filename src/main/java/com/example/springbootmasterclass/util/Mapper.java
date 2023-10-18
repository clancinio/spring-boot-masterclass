package com.example.springbootmasterclass.util;

import com.example.springbootmasterclass.model.Passenger;
import com.example.springbootmasterclass.repository.entity.PassengerEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Mapper {

  public static Passenger toPassenger(PassengerEntity entity) {
    return Passenger.builder()
        .id(entity.getId())
        .name(entity.getName())
        .email(entity.getEmail())
        .build();
  }
}
