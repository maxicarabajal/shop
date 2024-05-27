package com.tienda.shop.service;

import com.tienda.shop.dto.DetallePedidoDTO;
import com.tienda.shop.excepcion.EntityNotFoundException;
import com.tienda.shop.mapper.DetallePedidoMapper;
import com.tienda.shop.model.DetallePedido;
import com.tienda.shop.repository.IDetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        DetallePedidoDTO detallePedidoDTO = detallePedidoMapper.entityToDto(findDetallePedidoByIdEntity(id));
        return detallePedidoDTO;
    }

    @Override
    public DetallePedido findDetallePedidoByIdEntity(Long id) {
        Optional<DetallePedido> detallePedido = repoDetalle.findById(id);
        if(!detallePedido.isPresent()){
            throw new EntityNotFoundException("No se encontro el detalle con id: "+id);
        }
        return detallePedido.get();
    }

    @Override
    public void createDetallePedido(DetallePedidoDTO detallePedidoDTO) {
        repoDetalle.save(detallePedidoMapper.dtoToEntity(detallePedidoDTO));
    }

    @Override
    public void deleteDetallePedido(Long id) {
        DetallePedido detallePedido = findDetallePedidoByIdEntity(id);
        repoDetalle.delete(detallePedido);
    }
}
