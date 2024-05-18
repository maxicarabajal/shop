package com.tienda.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDetallePedido;

    @ManyToOne()
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    @ManyToOne()
    @JoinColumn(name = "id_producto")
    private Producto producto;
    private int cantidad;
    private double precioDetalle;
}
