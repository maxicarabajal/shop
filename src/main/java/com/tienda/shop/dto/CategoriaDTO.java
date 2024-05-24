package com.tienda.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaDTO {
    private Long idCategoria;
    private String nombre;
    private int cantProductos=0;
    private List<ProductoDTO> productoList = new ArrayList<>();

    public CategoriaDTO(String nombre) {
        this.nombre = nombre;
    }
}
