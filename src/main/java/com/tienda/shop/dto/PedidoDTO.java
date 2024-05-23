package com.tienda.shop.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoDTO {

    private Long idPedido;
    private Long vendedor;
    private Long cliente;
    private List<DetallePedidoDTO> detallePedidoList = new ArrayList<>();
    private int cantProductos;
    private double costeTotal;

    public PedidoDTO(Long vendedor, Long cliente, int cantProductos){
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.cantProductos = cantProductos;
        this.costeTotal = 0;
    }

}
