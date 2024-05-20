package com.tienda.shop.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriaDTO {
    private Long idCategoria;
    private String nombre;
    private int cantProductos;
    private List<ProductoDTO> productoList = new ArrayList<>();
}
