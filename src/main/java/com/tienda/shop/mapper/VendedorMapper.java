package com.tienda.shop.mapper;

import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.model.Vendedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper( componentModel = "spring", uses = {PedidoMapper.class})
public interface VendedorMapper {

    VendedorMapper INSTANCE = Mappers.getMapper(VendedorMapper.class);

    VendedorDTO vendedorToVendedorDTO(Vendedor vendedor);

    Vendedor vendedorDTOToVendedor(VendedorDTO vendedorDTO);

    List<VendedorDTO> vendedorListToVendedorDTOList(List<Vendedor> vendedorList);

    List<Vendedor> vendedorDTOListToVendedorList(List<VendedorDTO> vendedorDTOList);
}
