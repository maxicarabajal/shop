package com.tienda.shop.service;

import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.model.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoService {

    List<ProductoDTO> getAllProducto();

    ProductoDTO findProductoById(Long id);

    Producto findProductoByIdEntity(Long id);

    void createProducto(ProductoDTO productoDTO);

    void deleteProducto(Long id);

    void editProducto(Long id, ProductoDTO productoDTO);

    ProductoDTO findProductoByNombre(String nombre);

}
