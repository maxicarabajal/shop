package com.tienda.shop.controller;

import com.tienda.shop.model.Cliente;
import com.tienda.shop.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService serviCliente;

    @GetMapping("/cliente/get/all")
    private List<Cliente> getAllCliente(){
        return serviCliente.getAllCliente();
    }
}
