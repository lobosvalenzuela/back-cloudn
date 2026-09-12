package main.java.com.ms_stock.catalogo.service;

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
