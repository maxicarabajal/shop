package com.tienda.shop.controller;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import com.tienda.shop.service.IClienteService;
import jakarta.validation.Valid;
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

    @GetMapping("/cliente/get/dni/{dni}")
    private ClienteDTO getOneClienteByDni(@PathVariable String dni){
        return serviCliente.findClienteByDni(dni);
    }
    
    @PostMapping("/cliente/create")
    private void createCliente(@Valid @RequestBody ClienteDTO clienteDTO){
        serviCliente.createCliente(clienteDTO);
    }

    @DeleteMapping("/cliente/delete/{id}")
    private void deleteCliente(@PathVariable Long id){
        serviCliente.deleteCliente(id);
    }

    @PutMapping("/cliente/edit/{id}")
    private void editCliente(@PathVariable Long id,@Valid @RequestBody ClienteDTO clienteDTO){
        serviCliente.editCliente(id,clienteDTO);
    }



}
