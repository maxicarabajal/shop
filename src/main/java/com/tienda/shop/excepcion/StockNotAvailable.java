package com.tienda.shop.excepcion;


import lombok.Data;

@Data
public class StockNotAvailable extends RuntimeException{
    public StockNotAvailable(String message) {
        super(message);
    }
}
