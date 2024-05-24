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
    private ICategoriaService serviCategoria;


    @Override
    public List<ProductoDTO> getAllProducto() {
        return ProductoMapper.convertListToListDTO(repoProducto.findAll());
    }

    @Override
    public ProductoDTO findProductoById(Long id) {
        return ProductoMapper.convertProductoToProductoDTO(repoProducto.findById(id).orElse(null));
    }

    @Override
    public void createProducto(ProductoDTO productoDTO) {
        System.out.println("El producto essss: "+productoDTO);
        Categoria categoria = CategoriaMapper.convertCategoriaDTOToCategoria(serviCategoria.findCategoriaById(productoDTO.getCategoria()));
        repoProducto.save(ProductoMapper.convertProductoDTOToProducto(productoDTO));
        int cantProductos = categoria.getCantProductos();
        cantProductos = cantProductos+1;
        categoria.setCantProductos(cantProductos);
    }
}
