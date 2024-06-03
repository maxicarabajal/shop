package com.tienda.shop.repository;

import com.tienda.shop.model.Cliente;
import com.tienda.shop.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor,Long> {

    @Query("SELECT l FROM Vendedor l WHERE l.dni = :dni ")
    Optional<Vendedor> findVendedorByDni(String dni);
}
