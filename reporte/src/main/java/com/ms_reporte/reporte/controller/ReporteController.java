package main.java.com.ms_reporte.reporte.controller;

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
            oldReporte.setIdProducto(oldReporte.getIdProducto());
            oldReporte.setFechaReporte(oldReporte.getFechaReporte());
            oldReporte.setDescripcion(oldReporte.getDescripcion());
            Reporte updatedReporte = reporteService.updateReporte(oldReporte);
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
