package com.tienda.shop.service;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.mapper.DetallePedidoMapper;
import com.tienda.shop.repository.IDetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    private IDetallePedidoRepository repoDetalle;

    @Override
    public List<DetallePedidoDTO> getAllDetalle() {
        return DetallePedidoMapper.convertListToListDTO(repoDetalle.findAll());
    }

    @Override
    public DetallePedidoDTO findDetallePedidoById(Long id) {
        return DetallePedidoMapper.convertDetalleToDetalleDTO(repoDetalle.findById(id).orElse(null));
    }

    @Override
    public void createDetallePedido(DetallePedidoDTO detallePedidoDTO) {
        repoDetalle.save(DetallePedidoMapper.convertDetalleDTOToDetalle(detallePedidoDTO));
    }
}
