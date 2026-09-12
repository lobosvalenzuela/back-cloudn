package com.ms_reporte.reporte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_reporte.reporte.model.Reporte;
import com.ms_reporte.reporte.service.ReporteService;

@RestController
@RequestMapping("/api")
public class ReporteController {
    @Autowired
    private ReporteService reporteService;

    @GetMapping("/reportes")
    public ResponseEntity<List<Reporte>> getAllReportes() {
        List<Reporte> reportes = reporteService.getAllReportes();
        if(reportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportes);
    }

    @GetMapping("/reportes/{id}")
    public ResponseEntity<Reporte> getReporteById(@PathVariable Long id) {
        Reporte reporte = reporteService.getReporteById(id);
        if(reporte == null) {
            return ResponseEntity.notFound().build();  
        }
        return ResponseEntity.ok(reporte);
    }

    @PostMapping("/reportes")
    public ResponseEntity<Reporte> createReporte(@RequestBody Reporte reporte) {
        Reporte newReporte = reporteService.createReporte(reporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReporte);
    }

    @PutMapping("/reportes/{id}")
    public ResponseEntity<Reporte> updateReporte(@PathVariable Long id, @RequestBody Reporte reporte){
        try{
            Reporte oldReporte = reporteService.getReporteById(id);
            if(oldReporte == null) {
                return ResponseEntity.notFound().build();
            }
            oldReporte.setIdCliente(oldReporte.getIdCliente());
            oldReporte.setIdPedido(oldReporte.getIdPedido());
            oldReporte.setFechaReporte(oldReporte.getFechaReporte());
            oldReporte.setDescripcion(oldReporte.getDescripcion());
            Reporte updatedReporte = reporteService.createReporte(oldReporte);
            return ResponseEntity.ok(updatedReporte);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/reportes/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        Reporte reporte = reporteService.getReporteById(id);
        if(reporte == null) {
            return ResponseEntity.notFound().build();
        }
        reporteService.deleteReporte(id);
        return ResponseEntity.noContent().build();
    }
}
