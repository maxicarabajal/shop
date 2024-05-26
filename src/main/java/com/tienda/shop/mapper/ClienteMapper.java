package com.tienda.shop.mapper;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PedidoMapper.class})
public abstract class ClienteMapper {

    public abstract ClienteDTO entityToDto(Cliente cliente);

    public abstract Cliente dtoToEntity(ClienteDTO clienteDTO);

    public abstract List<Cliente> dtoListToEntityList(List<ClienteDTO> clienteDTOList);

    public abstract List<ClienteDTO> entityListToDtoList(List<Cliente> clienteList);

}
