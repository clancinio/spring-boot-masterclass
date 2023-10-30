package com.example.springbootmasterclass.common;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestConstant {

  public static final String FLIGHT_NUMBER = "CL1234";
  public static final String DEPARTURE_DATE = "28-04-2024";
  public static final String DEPARTURE_TIME = "13:45";
}
