package com.tienda.shop.service;

import com.tienda.shop.dto.VendedorDTO;
import com.tienda.shop.model.Vendedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVendedorService {

    List<VendedorDTO> getAllVendedor();

    VendedorDTO findVendedorById(Long id);

    void createVendedor(VendedorDTO vendedorDTO);
}
