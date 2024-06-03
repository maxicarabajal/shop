package com.tienda.shop.repository;

import com.tienda.shop.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {

    @Query("SELECT l FROM Categoria l WHERE l.nombre = :nombre")
    Optional<Categoria> findCategoriaByNombre(String nombre);
}
