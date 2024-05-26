package com.tienda.shop.service;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.model.DetallePedido;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDetallePedidoService{

    List<DetallePedidoDTO> getAllDetalle();

    DetallePedidoDTO findDetallePedidoById(Long id);

    DetallePedido findDetallePedidoByIdEntity(Long id);

    void createDetallePedido(DetallePedidoDTO detallePedidoDTO);

    void deleteDetallePedido(Long id);

}
