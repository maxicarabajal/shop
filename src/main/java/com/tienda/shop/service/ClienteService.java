package com.tienda.shop.service;

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
    public List<Cliente> getAllCliente() {
        return repoCliente.findAll();
    }
}
