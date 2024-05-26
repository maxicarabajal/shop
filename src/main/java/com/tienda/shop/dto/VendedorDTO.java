package com.tienda.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VendedorDTO {
    private Long idVendedor;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate nacimiento;
    private LocalDate antiguedad;
    private List<PedidoDTO> pedidoList = new ArrayList<>();

    /*public VendedorDTO(String nombre, String apellido, String dni, LocalDate nacimiento, LocalDate antiguedad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nacimiento = nacimiento;
        this.antiguedad = antiguedad;
    }*/
}
