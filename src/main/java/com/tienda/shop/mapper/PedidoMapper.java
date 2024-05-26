package com.tienda.shop.mapper;

import com.tienda.shop.dto.PedidoDTO;
import com.tienda.shop.model.Pedido;
import com.tienda.shop.repository.IClienteRepository;
import com.tienda.shop.repository.IVendedorRepository;
import com.tienda.shop.service.IClienteService;
import com.tienda.shop.service.IVendedorService;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DetallePedidoMapper.class, ClienteMapper.class})
public abstract class PedidoMapper {

    @Autowired
    private IClienteRepository clienteRepository;
    @Autowired
    private IVendedorRepository vendedorRepository;

    @Autowired
    private DetallePedidoMapper detallePedidoMapper;

    public Pedido dtoToEntity(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();
        pedido.setIdPedido(pedidoDTO.getIdPedido());
        pedido.setCliente(clienteRepository.findById(pedidoDTO.getCliente()).orElse(null));
        pedido.setVendedor(vendedorRepository.findById(pedidoDTO.getVendedor()).orElse(null));
        pedido.setCantProductos(pedidoDTO.getCantProductos());
        pedido.setDetallePedidoList(detallePedidoMapper.dtoListToEntityList(pedidoDTO.getDetallePedidoList()));
        pedido.setCosteTotal(pedidoDTO.getCosteTotal());

        return pedido;
    }

    public PedidoDTO entityToDto(Pedido pedido){
        System.out.println("es: "+pedido.getVendedor().getIdVendedor());
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setIdPedido(pedido.getIdPedido());
        pedidoDTO.setVendedor(pedido.getVendedor().getIdVendedor());
        pedidoDTO.setCliente(pedido.getCliente().getIdCliente());
        pedidoDTO.setCantProductos(pedido.getCantProductos());
        pedidoDTO.setDetallePedidoList(detallePedidoMapper.entityListToDtoList(pedido.getDetallePedidoList()));
        pedidoDTO.setCosteTotal(pedido.getCosteTotal());

        return pedidoDTO;
    }

    public abstract List<PedidoDTO> entityListToDtoList(List<Pedido> pedidoList);

    public abstract List<Pedido> dtoListToEntityList(List<PedidoDTO> pedidoDTOList);
}
