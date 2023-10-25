package com.example.springbootmasterclass.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorConstant {

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public final class Message{

    public static final String NOT_FOUND = "Passenger not found.";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error occurred.";
  }

}
