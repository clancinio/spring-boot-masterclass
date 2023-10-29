package com.example.springbootmasterclass.exception.handler;

import com.example.springbootmasterclass.api.model.reponse.ErrorDetail;
import com.example.springbootmasterclass.api.model.reponse.ErrorResponse;
import com.example.springbootmasterclass.constant.ErrorConstant.Message;
import com.example.springbootmasterclass.exception.NotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
    final ErrorDetail detail = new ErrorDetail(ex.getErrorName(), ex.getErrorReason());
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse(Message.NOT_FOUND, List.of(detail)));
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handleConstraintViolationException(
      ConstraintViolationException ex) {
    final Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

    List<ErrorDetail> errorDetails = constraintViolations.stream()
        .map(violation -> new ErrorDetail(
            violation.getPropertyPath().toString(),
            violation.getMessage()
        ))
        .collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse(Message.BAD_REQUEST, errorDetails));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex) {
    final ErrorDetail detail = new ErrorDetail(Message.INTERNAL_SERVER_ERROR, ex.getMessage());
    return ResponseEntity.internalServerError()
        .body(new ErrorResponse(Message.INTERNAL_SERVER_ERROR, List.of(detail)));
  }
}
