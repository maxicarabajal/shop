package com.tienda.shop.controller;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.service.IDetallePedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetallePedidoController {

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
    private void createDetallePedido(@Valid @RequestBody DetallePedidoDTO detallePedidoDTO){
        serviDetallePedido.createDetallePedido(detallePedidoDTO);
    }

    @DeleteMapping("/detalle/delete")
    private void deleteDetallePedido(@PathVariable Long id){
        serviDetallePedido.deleteDetallePedido(id);
    }
}
