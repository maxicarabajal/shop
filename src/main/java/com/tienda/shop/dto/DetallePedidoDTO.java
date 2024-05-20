package com.tienda.shop.dto;

import lombok.Data;

@Data
public class DetallePedidoDTO {
    private Long idDetallePedido;
    private Long pedido;
    private Long producto;
    private int cantidad;
    private double precioDetalle;
}
