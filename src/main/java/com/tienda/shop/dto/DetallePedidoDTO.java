package com.tienda.shop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "El id del producto debe ingresarse")
    private Long producto;

    @NotNull(message = "La cantidad del producto debe ingresarse")
    private int cantidad;

    private double precioDetalle;

    /*public DetallePedidoDTO(Long pedido, Long producto, int cantidad, double precioDetalle){
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioDetalle = precioDetalle;
    }*/
}
