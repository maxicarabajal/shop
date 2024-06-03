package com.tienda.shop.controller;

import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.service.IProductoService;
import com.tienda.shop.service.IVendedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendedorController {

    @Autowired
    private IVendedorService vendedorService;

    @GetMapping("/vendedor/get/all")
    private List<VendedorDTO> getAllVendedor(){
        return vendedorService.getAllVendedor();
    }

    @GetMapping("/vendedor/get/{id}")
    private VendedorDTO findVendedorById(@PathVariable Long id){
        return vendedorService.findVendedorById(id);
    }

    @GetMapping("/vendedor/get/dni/{dni}")
    private VendedorDTO findVendedorByDni(@PathVariable String dni){
        return vendedorService.findVendedorByDni(dni);
    }

    @PostMapping("/vendedor/create")
    private void createVendedor(@Valid @RequestBody VendedorDTO vendedorDTO){
        vendedorService.createVendedor(vendedorDTO);
    }

    @DeleteMapping("/vendedor/delete/{id}")
    private void deleteVendedor(@PathVariable Long id){
        vendedorService.deleteVendedor(id);
    }

    @PutMapping("/vendedor/edit/{id}")
    private void editVendedor(@PathVariable Long id,@Valid @RequestBody VendedorDTO vendedorDTO){
        vendedorService.editVendedor(id,vendedorDTO);
    }
}
