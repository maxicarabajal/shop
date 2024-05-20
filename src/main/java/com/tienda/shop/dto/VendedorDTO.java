package com.tienda.shop.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class VendedorDTO {
    private Long idVendedor;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate nacimiento;
    private LocalDate antiguedad;
    private List<PedidoDTO> pedidoList = new ArrayList<>();
}
