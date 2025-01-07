package br.com.restaurante.delivery.y_pedido.service;

import br.com.restaurante.delivery.y_pedido.api.PedidoAlteracaoRequest;
import br.com.restaurante.delivery.y_pedido.api.PedidoListResponse;
import br.com.restaurante.delivery.y_pedido.api.PedidoRequest;
import br.com.restaurante.delivery.y_pedido.api.PedidoResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    PedidoResponse criaPedido(UUID idCliente, @Valid PedidoRequest pedidoRequest);
    List<PedidoListResponse> buscaTodosPedidos();
    List<PedidoListResponse> buscarPedidosPorCliente(UUID idCliente);
    void deletaPedidoDoClienteComId(UUID idCliente, UUID idPedido);
    void alteraPedidoDoClienteComID(UUID idCliente, UUID idPedido, PedidoAlteracaoRequest pedidoAlteracaoRequest);
}
