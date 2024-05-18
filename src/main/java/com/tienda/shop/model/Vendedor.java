package com.tienda.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idVendedor;

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate nacimiento;
    private LocalDate antiguedad;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
}
