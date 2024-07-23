package com.TIDDEV.mhn.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public class CustomResponse<T> {
    private String message ;
    private HttpStatus status ;
    private T data ;
}
