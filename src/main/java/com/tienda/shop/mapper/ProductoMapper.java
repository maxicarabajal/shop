package com.tienda.shop.mapper;

import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.model.Producto;
import com.tienda.shop.repository.ICategoriaRepository;
import com.tienda.shop.repository.IProductoRepository;
import com.tienda.shop.service.ICategoriaService;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoriaMapper.class})
public abstract class ProductoMapper {

    @Autowired
    private ICategoriaRepository categoriaRepository;


    public ProductoDTO entityToDto(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIdProducto(producto.getIdProducto());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setStock(producto.getStock());
        productoDTO.setCategoria(producto.getCategoria().getIdCategoria());

        return productoDTO;
    }

    public Producto dtoToEntity(ProductoDTO productoDTO){
        Producto producto = new Producto();
        producto.setIdProducto(productoDTO.getIdProducto());
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        producto.setCategoria(categoriaRepository.findById(productoDTO.getCategoria()).orElse(null));

        return producto;
    }

    public abstract List<ProductoDTO> listEntityToListDto(List<Producto> productoList);

    public abstract List<Producto> listDtoToListEntity(List<ProductoDTO> productoDTOList);
}
