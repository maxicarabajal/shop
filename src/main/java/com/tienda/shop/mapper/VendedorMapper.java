package com.tienda.shop.mapper;

import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.model.Vendedor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class VendedorMapper {


    public static VendedorDTO convertVendedorToVendedorDTO(Vendedor vendedor){
        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setIdVendedor(vendedor.getIdVendedor());
        vendedorDTO.setNombre(vendedor.getNombre());
        vendedorDTO.setApellido(vendedor.getApellido());
        vendedorDTO.setDni(vendedor.getDni());
        vendedorDTO.setNacimiento(vendedor.getNacimiento());
        vendedorDTO.setAntiguedad(vendedor.getAntiguedad());
        vendedorDTO.setPedidoList(PedidoMapper.convertListToListDTO(vendedor.getPedidoList()));

        return vendedorDTO;
    }

    public static Vendedor convertVendedorDTOToVendedor(VendedorDTO vendedorDTO){
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(vendedorDTO.getIdVendedor());
        vendedor.setNombre(vendedorDTO.getNombre());
        vendedor.setApellido(vendedorDTO.getApellido());
        vendedor.setDni(vendedorDTO.getDni());
        vendedor.setNacimiento(vendedorDTO.getNacimiento());
        vendedor.setAntiguedad(vendedorDTO.getAntiguedad());
        vendedor.setPedidoList(PedidoMapper.convertListDTOToList(vendedorDTO.getPedidoList()));

        return vendedor;
    }

    public static List<VendedorDTO> convertListToListDTO(List<Vendedor> vendedorList){
        List<VendedorDTO> vendedorDTOList = new ArrayList<VendedorDTO>();
        for(Vendedor vendedor: vendedorList){
            VendedorDTO vendedorDTO = convertVendedorToVendedorDTO(vendedor);
            vendedorDTOList.add(vendedorDTO);
        }
        return vendedorDTOList;
    }
    public static List<Vendedor> convertListDTOToList(List<VendedorDTO> vendedorDTOList){
        List<Vendedor> vendedorList = new ArrayList<Vendedor>();
        for(VendedorDTO vendedorDTO: vendedorDTOList){
            Vendedor vendedor = convertVendedorDTOToVendedor(vendedorDTO);
            vendedorList.add(vendedor);
        }
        return vendedorList;
    }
}
