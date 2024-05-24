package com.tienda.shop.service;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.mapper.ClienteMapper;
import com.tienda.shop.model.Cliente;
import com.tienda.shop.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository repoCliente;

    @Override
    public List<ClienteDTO> getAllCliente() {

        return ClienteMapper.convertListToListDTO(repoCliente.findAll());
    }

    @Override
    public ClienteDTO findClienteById(Long id) {
        return ClienteMapper.convertClienteToClienteDTO(repoCliente.findById(id).orElse(null));
    }

    @Override
    public void createCliente(ClienteDTO clienteDTO) {
        repoCliente.save(ClienteMapper.convertClienteDTOToCliente(clienteDTO));
    }
}
