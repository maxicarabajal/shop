package com.tienda.shop.mapper;

import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.model.Vendedor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PedidoMapper.class})
public abstract class VendedorMapper {

    public abstract VendedorDTO entityToDto(Vendedor vendedor);

    public abstract Vendedor dtoToEntity(VendedorDTO vendedorDTO);

    public abstract List<VendedorDTO> entityListToDtoList(List<Vendedor> vendedorList);

    public abstract List<Vendedor> dtoListToEntityList(List<VendedorDTO> vendedorDTOList);

}
