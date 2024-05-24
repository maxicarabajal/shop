package com.tienda.shop.controller;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.service.IDetallePedidoService;
import com.tienda.shop.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetallePedido {

    @Autowired
    private IDetallePedidoService serviDetallePedido;


    @GetMapping("/detalle/get/all")
    private List<DetallePedidoDTO> getAllDetalle(){
        return serviDetallePedido.getAllDetalle();
    }

    @GetMapping("/detalle/get/{id}")
    private DetallePedidoDTO findDetalleById(@PathVariable Long id){
        return serviDetallePedido.findDetallePedidoById(id);
    }

    @PostMapping("/detalle/create")
    private void createDetallePedido(@RequestBody DetallePedidoDTO detallePedidoDTO){
        serviDetallePedido.createDetallePedido(detallePedidoDTO);
    }
}
