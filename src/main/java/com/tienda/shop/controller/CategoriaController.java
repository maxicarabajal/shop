package com.tienda.shop.controller;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.model.Categoria;
import com.tienda.shop.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private ICategoriaService serviCategoria;

    @GetMapping("/categoria/get/all")
    private List<CategoriaDTO> getAllCategoria(){
        return serviCategoria.getAllCategoria();
    }

    @GetMapping("/categoria/get/{id}")
    private CategoriaDTO findCategoriaById(@PathVariable Long id){
        return serviCategoria.findCategoriaById(id);
    }

    @PostMapping("/categoria/create")
    private void createCategoria(@RequestBody CategoriaDTO categoriaDTO){
        serviCategoria.createCategoria(categoriaDTO);
    }
}
