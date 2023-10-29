package com.example.springbootmasterclass.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Flight {

  @JsonProperty(access = Access.READ_ONLY)
  private Long id;

  @NotBlank
  private String flightNumber;

  @NotBlank
  private String departureDate;

  @NotBlank
  private String departureTime;
}
