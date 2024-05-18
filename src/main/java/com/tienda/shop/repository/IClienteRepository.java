package com.tienda.shop.repository;

import com.tienda.shop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository <Cliente, Long> {
}
