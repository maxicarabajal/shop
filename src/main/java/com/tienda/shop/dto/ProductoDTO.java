package com.tienda.shop.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long idProducto;
    private String nombre;
    private double precio;
    private int stock;
}
