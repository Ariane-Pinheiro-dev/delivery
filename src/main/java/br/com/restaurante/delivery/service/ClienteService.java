package br.com.restaurante.delivery.service;

import br.com.restaurante.delivery.api.ClienteDetalhadoResponse;
import br.com.restaurante.delivery.api.ClienteListResponse;
import br.com.restaurante.delivery.api.ClienteRequest;
import br.com.restaurante.delivery.api.ClienteResponse;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);
    List<ClienteListResponse> buscaTodosClientes();
    ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente);
}
