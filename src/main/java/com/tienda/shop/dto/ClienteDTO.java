package com.tienda.shop.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteDTO {
    private Long idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private List<PedidoDTO> pedidoList = new ArrayList<>();

}