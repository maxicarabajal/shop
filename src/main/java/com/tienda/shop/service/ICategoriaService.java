package com.tienda.shop.service;

import com.tienda.shop.dto.CategoriaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoriaService {

    List<CategoriaDTO> getAllCategoria();

    CategoriaDTO findCategoriaById(Long id);

    void createCategoria(CategoriaDTO categoriaDTO);
}
