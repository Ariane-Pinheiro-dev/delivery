package br.com.restaurante.delivery.pedido.service;

import br.com.restaurante.delivery.api.ClienteRequest;
import br.com.restaurante.delivery.api.ClienteResponse;

public interface PedidoService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);
}
