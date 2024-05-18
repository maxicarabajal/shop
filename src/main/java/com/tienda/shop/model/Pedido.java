package com.tienda.shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPedido;

    @ManyToOne()
    @JoinColumn(name = "id_vendedor")
    private Vendedor vendedor;

    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<DetallePedido> detallePedidoList;

    private int cantProductos;

    private double costeTotal;


}
