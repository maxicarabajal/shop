package com.tienda.shop.service;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {

    List<ClienteDTO> getAllCliente();

    void createCliente(ClienteDTO clienteDTO);



    //Cliente getOneCliente(Long id);

}
