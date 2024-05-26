package com.tienda.shop.service;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {

    List<ClienteDTO> getAllCliente();

    ClienteDTO findClienteById(Long id);

    Cliente findClienteByIdEntity(Long id);

    void createCliente(ClienteDTO clienteDTO);

    void deleteCliente(Long id);

    void editCliente(Long id, ClienteDTO clienteDTO);



    //Cliente getOneCliente(Long id);

}
