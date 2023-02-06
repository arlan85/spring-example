package com.wip.springexample.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CustomerExceptions extends RuntimeException {
        private String message;
        private HttpStatus httpStatus;

    public CustomerExceptions(String message, HttpStatus httpStatus) {
            super(message);
            this.message = message;
            this.httpStatus = httpStatus;
        }

    }
