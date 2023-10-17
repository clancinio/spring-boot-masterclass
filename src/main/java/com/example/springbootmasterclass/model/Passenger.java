package com.example.springbootmasterclass.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Passenger {

  private Long id;
  private String name;
}
