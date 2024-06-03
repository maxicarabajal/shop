package com.tienda.shop.repository;

import com.tienda.shop.dto.ClienteDTO;
import com.tienda.shop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long> {

    @Query("SELECT l FROM Cliente l WHERE l.dni = :dni ")
    Optional<Cliente> findClienteByDni(String dni);

}
