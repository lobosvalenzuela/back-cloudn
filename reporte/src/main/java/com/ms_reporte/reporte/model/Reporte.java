package main.java.com.ms_reporte.reporte.model;
@Entity
@Table(name = "reporte")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_pedido", nullable = false)
    private Long idPedido;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    @Column(name = "fecha_reporte", nullable = false)
    private Date fechaReporte;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
