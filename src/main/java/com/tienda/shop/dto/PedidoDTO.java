package com.tienda.shop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "El id del vendedor debe ingresarse")
    private Long vendedor;

    @NotNull(message = "El id del cliente debe ingresarse")
    private Long cliente;

    @NotNull(message = "No se puede hacer finalizar un pedido sin detalles")
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
