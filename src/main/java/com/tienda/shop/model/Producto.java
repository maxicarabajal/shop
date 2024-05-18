package com.tienda.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProducto;

    private String nombre;

    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    private double precio;
    private int stock;

}
