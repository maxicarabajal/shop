package com.tienda.shop.excepcion;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {
    private HttpStatus status;
    private String message;

}
