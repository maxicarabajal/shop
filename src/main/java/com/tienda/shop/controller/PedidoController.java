package com.tienda.shop.controller;

import com.tienda.shop.dto.PedidoDTO;
import com.tienda.shop.dto.ProductoDTO;
import com.tienda.shop.service.IPedidoService;
import com.tienda.shop.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService serviPedido;


    @GetMapping("/pedido/get/all")
    private List<PedidoDTO> getAllPedido(){
        return serviPedido.getAllPedido();
    }

    @GetMapping("/pedido/get/{id}")
    private PedidoDTO findPedidoById(@PathVariable Long id){
        return serviPedido.findPedidoById(id);
    }

    @PostMapping("/pedido/create")
    private void createPedido(@RequestBody PedidoDTO pedidoDTO){
        serviPedido.createPedido(pedidoDTO);
    }
}
