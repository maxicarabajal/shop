package com.tienda.shop.controller;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import com.tienda.shop.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService serviCliente;

    @GetMapping("/cliente/get/all")
    private List<ClienteDTO> getAllCliente(){
        return serviCliente.getAllCliente();
    }

    @GetMapping("/cliente/get/{id}")
    private ClienteDTO getOneCliente(@PathVariable Long id){
        return serviCliente.findClienteById(id);
    }
    
    @PostMapping("/cliente/create")
    private void createCliente(@RequestBody ClienteDTO clienteDTO){
        serviCliente.createCliente(clienteDTO);
    }


}
