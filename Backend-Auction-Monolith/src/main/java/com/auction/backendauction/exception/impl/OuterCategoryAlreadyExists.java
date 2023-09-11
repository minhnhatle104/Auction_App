package com.auction.backendauction.exception.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class OuterCategoryAlreadyExists extends RuntimeException {

    private String message;

    public OuterCategoryAlreadyExists(String message) {
        super(message);
        this.message = message;
    }

}
