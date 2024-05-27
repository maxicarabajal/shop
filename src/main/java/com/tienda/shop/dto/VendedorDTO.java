package com.tienda.shop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "El nombre ingresado no es valido")
    private String nombre;

    @NotBlank(message = "El apellido ingresado no es valido")
    private String apellido;

    @NotBlank(message = "El dni ingresado no es valido")
    private String dni;

    @NotNull(message = "La fecha de nacimiento ingresada no es valida")
    private LocalDate nacimiento;

    @NotNull(message = "La fecha de inicio o antiguedad no es valida")
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
