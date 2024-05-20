package com.tienda.shop.mapper;


import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PedidoMapper.class})
public interface ClienteMapper{

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    //Nos llega un cliente y lo pasamos a clienteDTO
    ClienteDTO clienteToClienteDTO(Cliente cliente);

    //Nos llega un clienteDTO y lo pasamos a cliente
    Cliente clienteDTOToCliente(ClienteDTO clienteDTO);

    List<ClienteDTO> clienteListToClienteDTOList(List<Cliente> clientes);

    List<Cliente> clienteDTOListToClienteList(List<ClienteDTO> clienteDTO);
}



