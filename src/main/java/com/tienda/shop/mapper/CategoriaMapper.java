package com.tienda.shop.mapper;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    CategoriaDTO categoriaToCategoriaDTO(Categoria categoria);

    Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO);

    List<CategoriaDTO> categoriaListToCategoriaDTOList(List<Categoria> categoriaList);

    List<Categoria> categoriaDTOListToCategoriaList(List<CategoriaDTO> categoriaDTOList);
}
