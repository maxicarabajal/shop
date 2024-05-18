package com.tienda.shop.service;

import com.tienda.shop.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {

    List<Cliente> getAllCliente();

    //Cliente getOneCliente(Long id);

}
