package com.tienda.shop.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoDTO {

    private Long idPedido;
    private Long idVendedor;
    private Long idCliente;
    private List<DetallePedidoDTO> detallePedidoDTOList;
    private int cantProducto;
    private double precio;
}
