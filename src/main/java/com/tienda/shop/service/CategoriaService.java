package com.tienda.shop.service;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.mapper.CategoriaMapper;
import com.tienda.shop.model.Categoria;
import com.tienda.shop.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    private ICategoriaRepository repoCategoria;

    @Override
    public List<CategoriaDTO> getAllCategoria() {
        return CategoriaMapper.convertListToListDTO(repoCategoria.findAll());
    }

    @Override
    public CategoriaDTO findCategoriaById(Long id) {
        System.out.println("la id es finnnd:"+id);
        Optional<Categoria> categoria = repoCategoria.findById(id);
        if(!categoria.isPresent()){
            System.out.println("No existe la categoria: "+categoria);
        }
        return CategoriaMapper.convertCategoriaToCategoriaDTO(categoria.get());
    }

    @Override
    public void createCategoria(CategoriaDTO categoriaDTO) {
        repoCategoria.save(CategoriaMapper.convertCategoriaDTOToCategoria(categoriaDTO));
    }
}
