package com.ms_reporte.reporte.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms_reporte.reporte.model.Reporte;


public interface ReporteRepository extends JpaRepository<Reporte, Long> {
}