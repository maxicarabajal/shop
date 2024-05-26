package com.tienda.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {
    private Long idProducto;
    private String nombre;
    private double precio;
    private int stock;
    private Long categoria;

    /*public ProductoDTO(String nombre, double precio, int stock, Long categoria){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }*/
}
