package com.tienda.shop.service;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.dto.PedidoDTO;
import com.tienda.shop.mapper.*;
import com.tienda.shop.model.DetallePedido;
import com.tienda.shop.model.Pedido;
import com.tienda.shop.model.Producto;
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
    private PedidoMapper pedidoMapper;
    @Autowired
    private ClienteMapper clienteMapper;
    @Autowired
    private VendedorMapper vendedorMapper;
    @Autowired
    private ProductoMapper productoMapper;

    @Override
    public List<PedidoDTO> getAllPedido() {
        return pedidoMapper.entityListToDtoList(repoPedido.findAll());
    }

    @Override
    public PedidoDTO findPedidoById(Long id) {
        return pedidoMapper.entityToDto(repoPedido.findById(id).orElse(null));
    }

    @Override
    public Pedido findPedidoByIdEntity(Long id) {
        return repoPedido.findById(id).orElse(null);
    }

    @Override
    public void createPedido(PedidoDTO pedidoDTO) {
        double costeTotal = 0;
        int cantidadProductos = 0;

        Pedido pedido = new Pedido();
        pedido.setCliente(serviCliente.findClienteByIdEntity(pedidoDTO.getCliente()));
        pedido.setVendedor(serviVendedor.findVendedorByIdEntity(pedidoDTO.getVendedor()));

        List<DetallePedido> detallePedidoList = new ArrayList<DetallePedido>();
        for(DetallePedidoDTO detallePedidoDTO: pedidoDTO.getDetallePedidoList()){
            DetallePedido detallePedido = new DetallePedido();

            detallePedido.setPedido(pedido);

            Producto producto = productoMapper.dtoToEntity(serviProducto.findProductoById(detallePedidoDTO.getProducto()));
            detallePedido.setProducto(producto);

            int cantidad = detallePedidoDTO.getCantidad();
            detallePedido.setCantidad(cantidad);
            cantidadProductos = cantidadProductos + cantidad;


            double precioDetalle = producto.getPrecio()*cantidad;
            detallePedido.setPrecioDetalle(precioDetalle);

            costeTotal = costeTotal + precioDetalle ;

        }

        pedido.setCosteTotal(costeTotal);
        pedido.setCantProductos(cantidadProductos);
        repoPedido.save(pedido);
    }

    @Override
    public void deletePedido(Long id) {
        repoPedido.deleteById(id);
    }
}
