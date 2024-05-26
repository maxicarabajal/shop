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
public class PedidoDTO {

    private Long idPedido;
    private Long vendedor;
    private Long cliente;
    private List<DetallePedidoDTO> detallePedidoList = new ArrayList<>();
    private int cantProductos;
    private double costeTotal;

    /*public PedidoDTO(Long vendedor, Long cliente, int cantProductos){
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.cantProductos = cantProductos;
        this.costeTotal = 0;
    }*/

}
