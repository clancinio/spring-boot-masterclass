package com.example.springbootmasterclass.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Passenger {

  private Long id;

  @NotBlank
  private String name;

  @Email
  @NotBlank
  private String email;
}
