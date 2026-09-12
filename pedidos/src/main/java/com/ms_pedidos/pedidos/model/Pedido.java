package com.ms_pedidos.pedidos.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "id_cliente")
    private Long idCliente;

    @Column(nullable = false, name = "id_producto")
    private Long idProducto;

    @Column(nullable = false, name = "fecha_pedido")
    private Date fechaPedido;

    @Column(nullable = false, name = "fecha_entrega")
    private Date fechaEntrega;

    @Column(nullable = false, name = "estado")
    private String estado;
}
