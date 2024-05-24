package com.tienda.shop.controller;

import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.service.IProductoService;
import com.tienda.shop.service.IVendedorService;
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

    @PostMapping("/vendedor/create")
    private void createVendedor(@RequestBody VendedorDTO vendedorDTO){
        vendedorService.createVendedor(vendedorDTO);
    }
}
