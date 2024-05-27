package com.tienda.shop.controller;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.service.ICategoriaService;
import com.tienda.shop.service.IProductoService;
import jakarta.validation.Valid;
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
    private void createProducto(@Valid @RequestBody ProductoDTO productoDTO){
        serviProducto.createProducto(productoDTO);
    }

    @DeleteMapping("/producto/delete/{id}")
    private void deleteProducto(@PathVariable Long id){
        serviProducto.deleteProducto(id);
    }

    @PutMapping("/producto/edit/{id}")
    private void editProducto(@PathVariable Long id,@Valid @RequestBody ProductoDTO productoDTO){
        serviProducto.editProducto(id,productoDTO);
    }
}
