package com.tienda.shop.mapper;


import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.model.DetallePedido;
import com.tienda.shop.service.IClienteService;
import com.tienda.shop.service.IPedidoService;
import com.tienda.shop.service.IProductoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class DetallePedidoMapper {

    private static IProductoService productoService;
    private static IClienteService clienteService;
    private static IPedidoService pedidoService;


    public static DetallePedidoDTO convertDetalleToDetalleDTO(DetallePedido detallePedido){
        DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();
        detallePedidoDTO.setIdDetallePedido(detallePedido.getIdDetallePedido());
        detallePedidoDTO.setPedido(detallePedido.getPedido().getIdPedido());
        detallePedidoDTO.setCantidad(detallePedido.getCantidad());
        detallePedidoDTO.setPrecioDetalle(detallePedido.getPrecioDetalle());
        detallePedidoDTO.setProducto(detallePedido.getProducto().getIdProducto());

        return detallePedidoDTO;
    }

    public static DetallePedido convertDetalleDTOToDetalle(DetallePedidoDTO detallePedidoDTO){
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setIdDetallePedido(detallePedido.getIdDetallePedido());
        detallePedido.setPedido(PedidoMapper.convertPedidoDTOToPedido(pedidoService.findPedidoById(detallePedidoDTO.getPedido())));
        detallePedido.setCantidad(detallePedidoDTO.getCantidad());
        detallePedido.setPrecioDetalle(detallePedidoDTO.getPrecioDetalle());
        detallePedido.setProducto(ProductoMapper.convertProductoDTOToProducto(productoService.findProductoById(detallePedidoDTO.getProducto())));

        return detallePedido;
    }

    public static List<DetallePedidoDTO> convertListToListDTO(List<DetallePedido> detallePedidoList){
        List<DetallePedidoDTO> detallePedidoDTOList = new ArrayList<>();
        for(DetallePedido detallePedido: detallePedidoList){
            DetallePedidoDTO detallePedidoDTO = convertDetalleToDetalleDTO(detallePedido);
            detallePedidoDTOList.add(detallePedidoDTO);
        }
        return detallePedidoDTOList;
    }

    public static List<DetallePedido> convertListDTOToList(List<DetallePedidoDTO> detallePedidoDTOList){
        List<DetallePedido> detallePedidoList = new ArrayList<>();
        for(DetallePedidoDTO detallePedidoDTO: detallePedidoDTOList){
            DetallePedido detallePedido = convertDetalleDTOToDetalle(detallePedidoDTO);
            detallePedidoList.add(detallePedido);
        }
        return detallePedidoList;
    }
}
