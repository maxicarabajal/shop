package com.tienda.shop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "El nombre de producto ingresado no es valido")
    private String nombre;
    @NotNull(message = "El precio de producto ingresado no es valido")
    private double precio;
    @NotNull(message = "El stock ingresado no es valido")
    private int stock;
    @NotNull(message = "El id de categoria debe ingresarse")
    private Long categoria;

    /*public ProductoDTO(String nombre, double precio, int stock, Long categoria){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }*/
}
