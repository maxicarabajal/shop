package com.tienda.shop.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long idProducto;
    private String nombre;
    private double precio;
    private int stock;

    public ProductoDTO(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
}
