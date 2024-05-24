package com.tienda.shop.mapper;

import com.tienda.shop.dto.CategoriaDTO;
import com.tienda.shop.model.Categoria;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



public class CategoriaMapper {

    public static Categoria convertCategoriaDTOToCategoria(CategoriaDTO categoriaDTO){
        Categoria categoria = new Categoria();
        System.out.println("La categoria id es: "+categoriaDTO.getIdCategoria());
        categoria.setIdCategoria(categoriaDTO.getIdCategoria());
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setCantProductos(categoriaDTO.getCantProductos());

        System.out.println("La cate es:"+categoria);
        return categoria;
    }

    public static CategoriaDTO convertCategoriaToCategoriaDTO(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setIdCategoria(categoria.getIdCategoria());
        categoriaDTO.setNombre(categoria.getNombre());
        categoriaDTO.setCantProductos(categoria.getCantProductos());

        categoriaDTO.setProductoList(ProductoMapper.convertListToListDTO(categoria.getProductoList()));

        return categoriaDTO;
    }

    public static List<CategoriaDTO> convertListToListDTO(List<Categoria> categoriaList){
        List<CategoriaDTO> categoriaDTOList = new ArrayList<>();
        for(Categoria categoria: categoriaList){
            CategoriaDTO categoriaDTO = convertCategoriaToCategoriaDTO(categoria);
            categoriaDTOList.add(categoriaDTO);
        }
        return categoriaDTOList;
    }

    public static List<Categoria> convertListToList(List<CategoriaDTO> categoriaDTOList){
        List<Categoria> categoriaList = new ArrayList<>();
        for(CategoriaDTO categoriaDTO: categoriaDTOList){
            Categoria categoria = convertCategoriaDTOToCategoria(categoriaDTO);
            categoriaList.add(categoria);
        }
        return categoriaList;
    }
}
