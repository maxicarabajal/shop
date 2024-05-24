package com.tienda.shop.service;

import com.tienda.shop.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPedidoService {

    List<PedidoDTO> getAllPedido();

    PedidoDTO findPedidoById(Long id);

    void createPedido(PedidoDTO pedidoDTO);
}
