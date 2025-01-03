package br.com.restaurante.delivery.z_pedido.service;

import br.com.restaurante.delivery.z_pedido.api.PedidoRequest;
import br.com.restaurante.delivery.z_pedido.api.PedidoResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface PedidoService {
    PedidoResponse criaPedido(UUID idCliente, @Valid PedidoRequest pedidoRequest);
}
