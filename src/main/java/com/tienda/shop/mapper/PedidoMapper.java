package com.tienda.shop.mapper;

import com.tienda.shop.dto.PedidoDTO;
import com.tienda.shop.model.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = {DetallePedidoMapper.class, ClienteMapper.class, VendedorMapper.class})
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoDTO pedidoToPedidoDTO(Pedido pedido);

    Pedido pedidoDTOToPedido(PedidoDTO pedidoDTO);

    List<PedidoDTO> pedidoListToPedidoDTOList(List<Pedido> pedidoList);

    List<Pedido> pedidoDTOListToPedidoList(List<PedidoDTO> pedidoDTOList);
}
