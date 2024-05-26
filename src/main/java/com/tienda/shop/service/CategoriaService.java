package com.tienda.shop.service;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.mapper.CategoriaMapper;
import com.tienda.shop.mapper.ProductoMapper;
import com.tienda.shop.model.Categoria;
import com.tienda.shop.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private ICategoriaRepository repoCategoria;
    @Autowired
    private ProductoMapper productoMapper;


    @Override
    public List<CategoriaDTO> getAllCategoria() {
        return categoriaMapper.listEntityToListDto(repoCategoria.findAll());
    }

    @Override
    public CategoriaDTO findCategoriaById(Long id) {
        return categoriaMapper.entityToDto(repoCategoria.findById(id).orElse(null));
    }

    @Override
    public Categoria findCategoriaByIdEntity(Long id) {
        return repoCategoria.findById(id).orElse(null);
    }

    @Override
    public void createCategoria(CategoriaDTO categoriaDTO) {
        repoCategoria.save(categoriaMapper.dtoToEntity(categoriaDTO));
    }

    @Override
    public void deleteCategoria(Long id) {
        repoCategoria.deleteById(id);
    }

    @Override
    public void editCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = findCategoriaByIdEntity(id);
        categoria.setIdCategoria(id);
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setCantProductos(categoriaDTO.getCantProductos());
        categoria.setProductoList(productoMapper.listDtoToListEntity(categoriaDTO.getProductoList()));

        repoCategoria.save(categoria);
    }
}
