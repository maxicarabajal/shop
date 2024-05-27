package com.tienda.shop.service;

import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.excepcion.EntityNotFoundException;
import com.tienda.shop.mapper.CategoriaMapper;
import com.tienda.shop.mapper.ProductoMapper;
import com.tienda.shop.model.Categoria;
import com.tienda.shop.model.Producto;
import com.tienda.shop.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository repoProducto;
    @Autowired
    private ProductoMapper productoMapper;
    @Autowired
    private CategoriaMapper categoriaMapper;



    @Override
    public List<ProductoDTO> getAllProducto() {
        return productoMapper.listEntityToListDto(repoProducto.findAll());
    }

    @Override
    public ProductoDTO findProductoById(Long id) {
        ProductoDTO productoDTO = productoMapper.entityToDto(findProductoByIdEntity(id));
        return productoDTO;
    }

    @Override
    public Producto findProductoByIdEntity(Long id) {
        Optional<Producto> producto = repoProducto.findById(id);
        if(!producto.isPresent()){
            throw new EntityNotFoundException("No se encontro un producto con id: "+id);
        }
        return producto.get();
    }

    @Override
    public void createProducto(ProductoDTO productoDTO) {
       Producto producto = productoMapper.dtoToEntity(productoDTO);
       Categoria categoria = producto.getCategoria();
       int cantProductos = categoria.getCantProductos() + 1;
       categoria.setCantProductos(cantProductos);

       repoProducto.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        repoProducto.deleteById(id);
    }

    @Override
    public void editProducto(Long id, ProductoDTO productoDTO) {
        Producto producto = findProductoByIdEntity(id);
        producto = productoMapper.dtoToEntity(productoDTO);
        producto.setIdProducto(id);

        repoProducto.save(producto);
    }
}
