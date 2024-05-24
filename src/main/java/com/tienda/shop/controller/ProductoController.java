package com.tienda.shop.controller;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.service.ICategoriaService;
import com.tienda.shop.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService serviProducto;


    @GetMapping("/producto/get/all")
    private List<ProductoDTO> getAllProducto(){
        return serviProducto.getAllProducto();
    }

    @GetMapping("/producto/get/{id}")
    private ProductoDTO findProductoById(@PathVariable Long id){
        return serviProducto.findProductoById(id);
    }

    @PostMapping("/producto/create")
    private void createProducto(@RequestBody ProductoDTO productoDTO){
        serviProducto.createProducto(productoDTO);
    }
}
