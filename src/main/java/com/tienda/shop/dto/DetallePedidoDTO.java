package com.tienda.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedidoDTO {
    private Long idDetallePedido;
    private Long pedido;
    private Long producto;
    private int cantidad;
    private double precioDetalle;

    public DetallePedidoDTO(Long pedido, Long producto, int cantidad, double precioDetalle){
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioDetalle = precioDetalle;
    }
}
