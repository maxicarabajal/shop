package com.tienda.shop.service;

import com.tienda.shop.dto.DetallePedidoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDetallePedidoService{

    List<DetallePedidoDTO> getAllDetalle();

    DetallePedidoDTO findDetallePedidoById(Long id);

    void createDetallePedido(DetallePedidoDTO detallePedidoDTO);
}
