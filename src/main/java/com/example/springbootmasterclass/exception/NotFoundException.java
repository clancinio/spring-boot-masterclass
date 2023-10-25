package com.example.springbootmasterclass.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NotFoundException extends RuntimeException{

  private final String errorName;
  private final String errorReason;
}