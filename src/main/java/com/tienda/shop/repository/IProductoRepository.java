package com.tienda.shop.repository;

import com.tienda.shop.model.Cliente;
import com.tienda.shop.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {

    @Query("SELECT l FROM Producto l WHERE l.nombre = :nombre")
    Optional<Producto> findProductoByNombre(String nombre);
}
