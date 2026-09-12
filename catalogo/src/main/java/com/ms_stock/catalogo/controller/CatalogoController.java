package com.ms_stock.catalogo.controller;

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

import com.ms_stock.catalogo.model.Catalogo;
import com.ms_stock.catalogo.service.CatalogoService;

@RestController
@RequestMapping("/api")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @GetMapping("/catalogos")
    public ResponseEntity<List<Catalogo>> getAllCatalogos() {
        List<Catalogo> catalogos = catalogoService.getAllCatalogos();
        if(catalogos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(catalogos);
    }

    @GetMapping("/catalogos/{id}")
    public ResponseEntity<Catalogo> getCatalogoById(@PathVariable Long id) {
        Catalogo catalogo = catalogoService.getCatalogoById(id);
        if(catalogo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(catalogo);
    }

    @PostMapping("/catalogos")
    public ResponseEntity<Catalogo> createCatalogo(@RequestBody Catalogo catalogo) {
        Catalogo newCatalogo = catalogoService.createCatalogo(catalogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCatalogo);
    }

    @PutMapping("/catalogos/{id}")
    public ResponseEntity<Catalogo> updateCatalogo(@PathVariable Long id, @RequestBody Catalogo catalogo){
        try{
            Catalogo oldCatalogo = catalogoService.getCatalogoById(id);
            oldCatalogo.setNombre(catalogo.getNombre());
            oldCatalogo.setDescripcion(catalogo.getDescripcion());
            oldCatalogo.setPrecio(catalogo.getPrecio());
            oldCatalogo.setStock(catalogo.getStock());
            Catalogo updatedCatalogo = catalogoService.createCatalogo(oldCatalogo);
            return ResponseEntity.ok(updatedCatalogo);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/catalogos/{id}")
    public ResponseEntity<Void> deleteCatalogo(@PathVariable Long id) {
        try {
            catalogoService.deleteCatalogo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
