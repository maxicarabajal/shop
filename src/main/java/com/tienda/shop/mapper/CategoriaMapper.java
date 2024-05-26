package com.tienda.shop.mapper;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.model.Categoria;
import com.tienda.shop.service.ICategoriaService;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProductoMapper.class})
public abstract class CategoriaMapper {

    public abstract CategoriaDTO entityToDto(Categoria categoria);

    public abstract Categoria dtoToEntity(CategoriaDTO categoriaDTO);

    public abstract List<CategoriaDTO> listEntityToListDto(List<Categoria> categoriaList);

    public abstract List<Categoria> listDtoToListEntity(List<Categoria> categoriaList);

}
