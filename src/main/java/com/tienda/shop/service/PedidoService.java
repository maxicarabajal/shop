package com.tienda.shop.service;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.dto.PedidoDTO;
import com.tienda.shop.mapper.*;
import com.tienda.shop.model.DetallePedido;
import com.tienda.shop.model.Pedido;
import com.tienda.shop.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService implements IPedidoService{

    @Autowired
    private IPedidoRepository repoPedido;
    @Autowired
    private IClienteService serviCliente;
    @Autowired
    private IVendedorService serviVendedor;
    @Autowired
    private IProductoService serviProducto;
    @Autowired

    @Override
    public List<PedidoDTO> getAllPedido() {
        return PedidoMapper.convertListToListDTO(repoPedido.findAll());
    }

    @Override
    public PedidoDTO findPedidoById(Long id) {
        return PedidoMapper.convertPedidoToPedidoDTO(repoPedido.findById(id).orElse(null));
    }

    @Override
    public void createPedido(PedidoDTO pedidoDTO) {
        double costeTotal = 0;
        int cantidadProductos = 0;

        Pedido pedido = new Pedido();
        pedido.setCliente(ClienteMapper.convertClienteDTOToCliente(serviCliente.findClienteById(pedidoDTO.getCliente())));
        pedido.setVendedor(VendedorMapper.convertVendedorDTOToVendedor(serviVendedor.findVendedorById(pedidoDTO.getVendedor())));

        List<DetallePedido> detallePedidoList = new ArrayList<DetallePedido>();
        for(DetallePedidoDTO detallePedidoDTO: pedidoDTO.getDetallePedidoList()){
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setPedido(pedido);
            detallePedido.setPrecioDetalle(detallePedidoDTO.getPrecioDetalle());
            detallePedido.setProducto(ProductoMapper.convertProductoDTOToProducto(serviProducto.findProductoById(detallePedidoDTO.getProducto())));
            detallePedido.setCantidad(detallePedidoDTO.getCantidad());

            costeTotal = costeTotal + detallePedidoDTO.getPrecioDetalle();
            cantidadProductos = cantidadProductos+detallePedidoDTO.getCantidad();
        }

        pedido.setCosteTotal(costeTotal);
        pedido.setCantProductos(cantidadProductos);

        repoPedido.save(pedido);
    }
}
