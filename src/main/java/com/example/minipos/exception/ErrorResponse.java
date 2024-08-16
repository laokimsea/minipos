package com.example.minipos.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private HttpStatus status;
    private String messageString;
}
