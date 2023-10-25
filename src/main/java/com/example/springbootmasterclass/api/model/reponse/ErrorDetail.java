package com.example.springbootmasterclass.api.model.reponse;

public record ErrorDetail(
    String errorName,
    String errorReason
) {

}
