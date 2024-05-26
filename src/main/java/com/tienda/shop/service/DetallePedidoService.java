package com.tienda.shop.service;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.mapper.DetallePedidoMapper;
import com.tienda.shop.model.DetallePedido;
import com.tienda.shop.repository.IDetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoService implements IDetallePedidoService {

    @Autowired
    private IDetallePedidoRepository repoDetalle;
    @Autowired
    private DetallePedidoMapper detallePedidoMapper;


    @Override
    public List<DetallePedidoDTO> getAllDetalle() {
        return detallePedidoMapper.entityListToDtoList(repoDetalle.findAll());
    }

    @Override
    public DetallePedidoDTO findDetallePedidoById(Long id) {
        return detallePedidoMapper.entityToDto(repoDetalle.findById(id).orElse(null));
    }

    @Override
    public DetallePedido findDetallePedidoByIdEntity(Long id) {
        return repoDetalle.findById(id).orElse(null);
    }

    @Override
    public void createDetallePedido(DetallePedidoDTO detallePedidoDTO) {
        repoDetalle.save(detallePedidoMapper.dtoToEntity(detallePedidoDTO));
    }

    @Override
    public void deleteDetallePedido(Long id) {
        repoDetalle.deleteById(id);
    }
}
