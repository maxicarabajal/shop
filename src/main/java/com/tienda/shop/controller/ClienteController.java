package com.tienda.shop.controller;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import com.tienda.shop.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService serviCliente;

    @GetMapping("/cliente/get/all")
    private List<ClienteDTO> getAllCliente(){
        return serviCliente.getAllCliente();
    }
    
    @PostMapping("/cliente/create")
    private void createCliente(@RequestBody ClienteDTO clienteDTO){
        serviCliente.createCliente(clienteDTO);
    }
}
