package br.com.restaurante.delivery.z_pedido.repository;

import br.com.restaurante.delivery.z_pedido.domain.Pedido;

public interface PedidoRepository {
    Pedido salva(Pedido pedido);
    Pedido salvaPedido(Pedido pedido);
}
