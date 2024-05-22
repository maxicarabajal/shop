package com.tienda.shop.repository;

import com.tienda.shop.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor,Long> {
}
