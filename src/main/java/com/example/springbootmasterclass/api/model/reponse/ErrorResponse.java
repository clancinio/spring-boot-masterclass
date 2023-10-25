package com.example.springbootmasterclass.api.model.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Collections;
import java.util.List;

@JsonInclude(Include.NON_EMPTY)
public record ErrorResponse(
    String message,
    List<ErrorDetail> details
) {

  public ErrorResponse(String message) {
    this(message, Collections.emptyList());
  }
}
