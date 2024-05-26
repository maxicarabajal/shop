package com.tienda.shop.service;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.model.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoriaService {

    List<CategoriaDTO> getAllCategoria();

    CategoriaDTO findCategoriaById(Long id);

    Categoria findCategoriaByIdEntity(Long id);

    void createCategoria(CategoriaDTO categoriaDTO);

    void deleteCategoria(Long id);

    void editCategoria(Long id, CategoriaDTO categoriaDTO);
}
