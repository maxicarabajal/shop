package com.tienda.shop.service;

import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.mapper.VendedorMapper;
import com.tienda.shop.model.Vendedor;
import com.tienda.shop.repository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService implements IVendedorService {

    @Autowired
    private IVendedorRepository repoVendedor;
    @Autowired
    private VendedorMapper vendedorMapper;


    @Override
    public List<VendedorDTO> getAllVendedor() {
        return vendedorMapper.entityListToDtoList(repoVendedor.findAll());
    }

    @Override
    public VendedorDTO findVendedorById(Long id) {
        return vendedorMapper.entityToDto(repoVendedor.findById(id).orElse(null));
    }

    @Override
    public Vendedor findVendedorByIdEntity(Long id) {
        return repoVendedor.findById(id).orElse(null);
    }

    @Override
    public void createVendedor(VendedorDTO vendedorDTO) {
        repoVendedor.save(vendedorMapper.dtoToEntity(vendedorDTO));
    }
}
