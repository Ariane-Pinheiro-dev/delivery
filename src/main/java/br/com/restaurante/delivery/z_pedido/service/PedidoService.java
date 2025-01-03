package br.com.restaurante.delivery.z_pedido.service;

import br.com.restaurante.delivery.z_pedido.api.PedidoRequest;

public interface PedidoService {
    PedidoService criaPedido(PedidoRequest clienteRequest);
}
