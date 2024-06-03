package com.tienda.shop.controller;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.model.Categoria;
import com.tienda.shop.service.ICategoriaService;
import jakarta.validation.Valid;
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

    @GetMapping("/categoria/get/nombre/{nombre}")
    private CategoriaDTO findCategoriaByNombre(@PathVariable String nombre){
        return serviCategoria.findCategoriaByNombre(nombre);
    }

    @PostMapping("/categoria/create")
    private void createCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        serviCategoria.createCategoria(categoriaDTO);
    }

    @DeleteMapping("/categoria/delete/{id}")
    private void deleteCategoria(@PathVariable Long id){
        serviCategoria.deleteCategoria(id);
    }

    @DeleteMapping("/categoria/edit/{id}")
    private void editCategoria(@PathVariable Long id,@Valid @RequestBody CategoriaDTO categoriaDTO){
        serviCategoria.editCategoria(id,categoriaDTO);
    }
}
