package com.ms_reporte.reporte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_reporte.reporte.model.Reporte;
import com.ms_reporte.reporte.repository.ReporteRepository;

@Service
public class ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> getAllReportes() {
        return reporteRepository.findAll();
    }

    public Reporte getReporteById(Long id) {
        return reporteRepository.findById(id).orElse(null);
    }

    public Reporte createReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public void deleteReporte(Long id) {
        reporteRepository.deleteById(id);
    }
}
