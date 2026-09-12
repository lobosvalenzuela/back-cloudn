package com.ms_pedidos.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms_pedidos.pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
