package com.example.springbootmasterclass.exception.handler;

import com.example.springbootmasterclass.api.model.reponse.ErrorDetail;
import com.example.springbootmasterclass.api.model.reponse.ErrorResponse;
import com.example.springbootmasterclass.constant.ErrorConstant.Message;
import com.example.springbootmasterclass.exception.NotFoundException;
import java.util.List;
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

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleNotFoundException(Exception ex) {
    return ResponseEntity.internalServerError()
        .body(new ErrorResponse(Message.INTERNAL_SERVER_ERROR));
  }
}
