package com.example.springbootmasterclass.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ErrorConstant {

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public final class Message{

    public static final String NOT_FOUND = "Flight not found.";
    public static final String INTERNAL_SERVER_ERROR = "Internal server error occurred.";
    public static final String BAD_REQUEST = "Request parameter didn't validate.";
  }

}
