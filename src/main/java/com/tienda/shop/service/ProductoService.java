package com.tienda.shop.service;

import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.mapper.CategoriaMapper;
import com.tienda.shop.mapper.ProductoMapper;
import com.tienda.shop.model.Categoria;
import com.tienda.shop.model.Producto;
import com.tienda.shop.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository repoProducto;
    @Autowired
    private ProductoMapper productoMapper;



    @Override
    public List<ProductoDTO> getAllProducto() {
        return productoMapper.listEntityToListDto(repoProducto.findAll());
    }

    @Override
    public ProductoDTO findProductoById(Long id) {
        return productoMapper.entityToDto(repoProducto.findById(id).orElse(null));
    }

    @Override
    public Producto findProductoByIdEntity(Long id) {
        return repoProducto.findById(id).orElse(null);
    }

    @Override
    public void createProducto(ProductoDTO productoDTO) {
       Producto producto = productoMapper.dtoToEntity(productoDTO);
       Categoria categoria = producto.getCategoria();
       int cantProductos = categoria.getCantProductos() + 1;
       categoria.setCantProductos(cantProductos);

       repoProducto.save(producto);
    }
}
