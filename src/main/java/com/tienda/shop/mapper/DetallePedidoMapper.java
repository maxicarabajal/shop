package com.tienda.shop.mapper;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.model.DetallePedido;
import com.tienda.shop.repository.IPedidoRepository;
import com.tienda.shop.repository.IProductoRepository;
import com.tienda.shop.service.IClienteService;
import com.tienda.shop.service.IPedidoService;
import com.tienda.shop.service.IProductoService;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,uses = {PedidoMapper.class, ProductoMapper.class})
public abstract class DetallePedidoMapper {

    @Autowired
    private IPedidoRepository pedidoRepository;
    @Autowired
    private IProductoRepository productoRepository;

    public DetallePedidoDTO entityToDto(DetallePedido detallePedido){
        DetallePedidoDTO detallePedidoDTO = new DetallePedidoDTO();
        detallePedidoDTO.setIdDetallePedido(detallePedido.getIdDetallePedido());
        detallePedidoDTO.setPedido(detallePedido.getIdDetallePedido());
        detallePedidoDTO.setProducto(detallePedido.getProducto().getIdProducto());
        detallePedidoDTO.setCantidad(detallePedido.getCantidad());
        detallePedidoDTO.setPrecioDetalle(detallePedido.getPrecioDetalle());

        return detallePedidoDTO;
    }

    public DetallePedido dtoToEntity(DetallePedidoDTO detallePedidoDTO){
        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setIdDetallePedido(detallePedidoDTO.getIdDetallePedido());
        detallePedido.setPedido(pedidoRepository.findById(detallePedidoDTO.getPedido()).orElse(null));
        detallePedido.setProducto(productoRepository.findById(detallePedidoDTO.getProducto()).orElse(null));
        detallePedido.setCantidad(detallePedidoDTO.getCantidad());
        detallePedido.setPrecioDetalle(detallePedidoDTO.getPrecioDetalle());

        return detallePedido;
    }

    public abstract List<DetallePedidoDTO> entityListToDtoList(List<DetallePedido> detallePedidoList);

    public abstract List<DetallePedido> dtoListToEntityList(List<DetallePedidoDTO> detallePedidoDTOList);
}
