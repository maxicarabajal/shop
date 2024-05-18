package com.tienda.shop.dto;

import lombok.Data;

@Data
public class DetallePedidoDTO {
    private Long idDetallePedido;
    private Long idPedido;
    private Long idProducto;
    private int cantProducto;
    private double precioDetalle;
}
