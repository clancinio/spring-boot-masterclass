package com.example.springbootmasterclass.api.model;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Flight {

  private Long id;

  @NotBlank
  private String flightNumber;

  @NotBlank
  private String departureDate;

  @NotBlank
  private String departureTime;
}
