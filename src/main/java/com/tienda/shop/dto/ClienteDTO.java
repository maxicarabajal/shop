package com.tienda.shop.dto;

import jakarta.validation.constraints.NotBlank;
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
public class ClienteDTO {
    private Long idCliente;
    @NotBlank(message = "El nombre ingresado no es valido")
    private String nombre;
    @NotBlank(message = "El apellido ingresado no es valido")
    private String apellido;
    @NotBlank(message = "El dni ingresado no es valido")
    private String dni;

    private List<PedidoDTO> pedidoList = new ArrayList<>();

    /*public ClienteDTO(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }*/
}
