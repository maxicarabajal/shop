package com.tienda.shop.service;

import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.excepcion.EntityNotFoundException;
import com.tienda.shop.mapper.VendedorMapper;
import com.tienda.shop.model.Vendedor;
import com.tienda.shop.repository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        VendedorDTO vendedorDTO = vendedorMapper.entityToDto(findVendedorByIdEntity(id));
        return vendedorDTO;
    }

    @Override
    public Vendedor findVendedorByIdEntity(Long id) {
        Optional<Vendedor> vendedor = repoVendedor.findById(id);
        if(!vendedor.isPresent()){
            throw new EntityNotFoundException("No se encontro un vendedor con id: "+id);
        }
        return vendedor.get();
    }

    @Override
    public void createVendedor(VendedorDTO vendedorDTO) {
        repoVendedor.save(vendedorMapper.dtoToEntity(vendedorDTO));
    }

    @Override
    public void deleteVendedor(Long id) {
        Vendedor vendedor = findVendedorByIdEntity(id);
        repoVendedor.delete(vendedor);
    }

    @Override
    public void editVendedor(Long id, VendedorDTO vendedorDTO) {
        Vendedor vendedor = findVendedorByIdEntity(id);
        vendedor = vendedorMapper.dtoToEntity(vendedorDTO);
        vendedor.setIdVendedor(id);
        repoVendedor.save(vendedor);
    }

    @Override
    public VendedorDTO findVendedorByDni(String dni) {
        Optional<Vendedor> vendedor = repoVendedor.findVendedorByDni(dni);
        if(!vendedor.isPresent()){
            throw new EntityNotFoundException("No se encontro el vendedor con dni: "+dni);
        }
        return vendedorMapper.entityToDto(vendedor.get());
    }

}
