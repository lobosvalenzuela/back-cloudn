package main.java.com.ms_reporte.reporte.service;

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
