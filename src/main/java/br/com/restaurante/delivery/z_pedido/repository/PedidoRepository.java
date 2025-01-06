package br.com.restaurante.delivery.z_pedido.repository;

import br.com.restaurante.delivery.z_pedido.domain.Pedido;

import java.util.List;

public interface PedidoRepository {
    Pedido save(Pedido pedido);
    List<Pedido> findyAll();
    List<Pedido> buscaPedidosPorCliente(String idCliente);
}
