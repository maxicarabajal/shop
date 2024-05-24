package com.tienda.shop.service;

import com.tienda.shop.dto.ProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductoService {

    List<ProductoDTO> getAllProducto();

    ProductoDTO findProductoById(Long id);

    void createProducto(ProductoDTO productoDTO);

}
