package com.tienda.shop.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private List<PedidoDTO> pedidoDTOList;

}
