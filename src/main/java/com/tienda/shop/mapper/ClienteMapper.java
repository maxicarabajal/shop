package com.tienda.shop.mapper;


import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import com.tienda.shop.model.Vendedor;
import com.tienda.shop.repository.IVendedorRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class ClienteMapper {

    public static IVendedorRepository vendedorRepository;


    public static ClienteDTO convertClienteToClienteDTO(Cliente cliente){
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(cliente.getIdCliente());
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setDni(cliente.getDni());


        clienteDTO.setPedidoList(PedidoMapper.convertListToListDTO(cliente.getPedidoList()));

        return clienteDTO;
    }

    public static Cliente convertClienteDTOToCliente(ClienteDTO clienteDTO){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setApellido(clienteDTO.getApellido());
        cliente.setDni(clienteDTO.getDni());
        cliente.setPedidoList(PedidoMapper.convertListDTOToList(clienteDTO.getPedidoList()));

        return cliente;
    }

    public static List<Cliente> convertListDTOToList(List<ClienteDTO> clienteDTOList){
        List<Cliente> clienteList = new ArrayList<Cliente>();
        for(ClienteDTO clienteDTO: clienteDTOList){
            Cliente cliente = convertClienteDTOToCliente(clienteDTO);
            clienteList.add(cliente);
        }
        return clienteList;
    }

    public static List<ClienteDTO> convertListToListDTO(List<Cliente> clienteList){
        List<ClienteDTO> clienteDTOList = new ArrayList<ClienteDTO>();
        for(Cliente cliente: clienteList){
            ClienteDTO clienteDTO = convertClienteToClienteDTO(cliente);
            clienteDTOList.add(clienteDTO);
        }
        return clienteDTOList;
    }
}
