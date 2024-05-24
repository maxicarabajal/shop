package com.tienda.shop.service;

import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.mapper.VendedorMapper;
import com.tienda.shop.repository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService implements IVendedorService {

    @Autowired
    private IVendedorRepository repoVendedor;


    @Override
    public List<VendedorDTO> getAllVendedor() {
        return VendedorMapper.convertListToListDTO(repoVendedor.findAll());
    }

    @Override
    public VendedorDTO findVendedorById(Long id) {
        return VendedorMapper.convertVendedorToVendedorDTO(repoVendedor.findById(id).orElse(null));
    }

    @Override
    public void createVendedor(VendedorDTO vendedorDTO) {
        repoVendedor.save(VendedorMapper.convertVendedorDTOToVendedor(vendedorDTO));
    }
}
