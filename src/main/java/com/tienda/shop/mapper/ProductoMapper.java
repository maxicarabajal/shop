package com.tienda.shop.mapper;

import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.model.Categoria;
import com.tienda.shop.model.Cliente;
import com.tienda.shop.model.Producto;
import com.tienda.shop.repository.ICategoriaRepository;
import com.tienda.shop.repository.IClienteRepository;
import com.tienda.shop.service.CategoriaService;
import com.tienda.shop.service.ICategoriaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductoMapper {



    public static ICategoriaService categoriaService;
    public static ICategoriaRepository categoriaRepository;
    public static IClienteRepository clienteRepository;
    public static CategoriaMapper categoriaMapper;

    public static ProductoDTO convertProductoToProductoDTO(Producto producto){
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIdProducto(producto.getIdProducto());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setStock(producto.getStock());
        productoDTO.setCategoria(producto.getCategoria().getIdCategoria());

        return productoDTO;
    }

    public static Producto convertProductoDTOToProducto(ProductoDTO productoDTO){
        Producto producto = new Producto();

        producto.setIdProducto(productoDTO.getIdProducto());
        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        System.out.println("laaaa id es: "+productoDTO.getCategoria());

        //producto.setCategoria(CategoriaMapper.convertCategoriaDTOToCategoria(categoriaService.findCategoriaById(1L)));
        //Categoria categoria = CategoriaMapper.convertCategoriaDTOToCategoria(categoriaService.findCategoriaById(productoDTO.getCategoria()));
        //System.out.println("La categoria a establecer es:"+categoria);



        producto.setCategoria(CategoriaMapper.convertCategoriaDTOToCategoria(categoriaService.findCategoriaById(productoDTO.getCategoria())));
        producto.setCategoria(categoriaRepository.findById(1L).orElse(null));
        System.out.println("la categoria establecida es: "+producto.getCategoria());
        return producto;
    }

    public static List<Producto> convertListDTOToList(List<ProductoDTO> productoDTOList){
        List<Producto> productoList = new ArrayList<>();
        for(ProductoDTO productoDTO: productoDTOList){
            Producto producto = convertProductoDTOToProducto(productoDTO);
            productoList.add(producto);
        }
        return productoList;
    }

    public static List<ProductoDTO> convertListToListDTO(List<Producto> productoList){
        List<ProductoDTO> productoDTOList = new ArrayList<>();
        for(Producto producto: productoList){
            ProductoDTO productoDTO = convertProductoToProductoDTO(producto);
            productoDTOList.add(productoDTO);
        }
        return productoDTOList;
    }

}
