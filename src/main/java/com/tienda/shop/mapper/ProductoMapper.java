package com.tienda.shop.mapper;

import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.model.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring" ,uses = {CategoriaMapper.class})
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    ProductoDTO productoToProductoDTO(Producto producto);

    Producto productoDTOToProducto(ProductoDTO productoDTO);

    List<ProductoDTO> productoListToProductoDTOList(List<Producto> productoList);

    List<Producto> productoDTOListToProductoList(List<ProductoDTO> productoDTOList);
}
