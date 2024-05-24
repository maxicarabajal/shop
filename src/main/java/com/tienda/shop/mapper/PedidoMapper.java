package com.tienda.shop.mapper;

import com.tienda.shop.dto.PedidoDTO;
import com.tienda.shop.model.Pedido;
import com.tienda.shop.repository.IClienteRepository;
import com.tienda.shop.service.IClienteService;
import com.tienda.shop.service.IVendedorService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class PedidoMapper {

    private static IClienteService clienteService;
    private static IVendedorService vendedorService;

    public static PedidoDTO convertPedidoToPedidoDTO(Pedido pedido){
        PedidoDTO pedidoDTO = new PedidoDTO();

        pedidoDTO.setIdPedido(pedidoDTO.getIdPedido());
        pedidoDTO.setCliente(pedido.getCliente().getIdCliente());
        pedidoDTO.setCantProductos(pedido.getCantProductos());
        pedidoDTO.setCosteTotal(pedido.getCosteTotal());
        pedidoDTO.setVendedor(pedido.getVendedor().getIdVendedor());
        pedidoDTO.setDetallePedidoList(DetallePedidoMapper.convertListToListDTO(pedido.getDetallePedidoList()));

        return pedidoDTO;
    }

    public static Pedido convertPedidoDTOToPedido(PedidoDTO pedidoDTO){
        Pedido pedido = new Pedido();

        pedido.setIdPedido(pedidoDTO.getIdPedido());
        pedido.setCliente(ClienteMapper.convertClienteDTOToCliente(clienteService.findClienteById(pedidoDTO.getCliente())));
        pedido.setCantProductos(pedidoDTO.getCantProductos());
        pedido.setCosteTotal(pedidoDTO.getCosteTotal());
        pedido.setVendedor(VendedorMapper.convertVendedorDTOToVendedor(vendedorService.findVendedorById(pedidoDTO.getVendedor())));
        pedido.setDetallePedidoList(DetallePedidoMapper.convertListDTOToList(pedidoDTO.getDetallePedidoList()));

        return pedido;
    }

    public static List<Pedido> convertListDTOToList(List<PedidoDTO> pedidoDTOList){
        List<Pedido> pedidoList = new ArrayList<>();
        for(PedidoDTO pedidoDTO: pedidoDTOList){
            Pedido pedido = convertPedidoDTOToPedido(pedidoDTO);
            pedidoList.add(pedido);
        }
        return pedidoList;
    }

    public static List<PedidoDTO> convertListToListDTO(List<Pedido> pedidoList){
        List<PedidoDTO> pedidoDTOList = new ArrayList<>();
        for(Pedido pedido: pedidoList){
            PedidoDTO pedidoDTO = convertPedidoToPedidoDTO(pedido);
            pedidoDTOList.add(pedidoDTO);
        }
        return pedidoDTOList;
    }
}
