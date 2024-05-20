package com.tienda.shop.mapper;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.model.DetallePedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PedidoMapper.class , ProductoMapper.class})
public interface DetallePedidoMapper {

    DetallePedidoMapper INSTANCE = Mappers.getMapper(DetallePedidoMapper.class);

    DetallePedidoDTO detalleToDetalleDTO(DetallePedido detallePedido);

    DetallePedido detalleDTOToDetalle(DetallePedidoDTO detallePedidoDTO);

    List<DetallePedidoDTO> detalleListToDetalleDTOList(List<DetallePedido> detallePedidoList);

    List<DetallePedido> detalleDTOListToDetalleList(List<DetallePedidoDTO> detallePedidoDTOList);

}
