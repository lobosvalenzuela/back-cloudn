package com.ms_stock.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms_stock.catalogo.model.Catalogo;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {

}
