package com.ms_stock.catalogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_stock.catalogo.model.Catalogo;
import com.ms_stock.catalogo.repository.CatalogoRepository;

@Service
public class CatalogoService {
    @Autowired
    private CatalogoRepository catalogoRepository;

    public List<Catalogo> getAllCatalogos() {
        return catalogoRepository.findAll();
    }

    public Catalogo getCatalogoById(Long id) {
        return catalogoRepository.findById(id).orElse(null);
    }

    public Catalogo createCatalogo(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    public void deleteCatalogo(Long id) {
        catalogoRepository.deleteById(id);
    }
}
