package br.com.restaurante.delivery.service;

import br.com.restaurante.delivery.api.*;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);
    List<ClienteListResponse> buscaTodosClientes();
    ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente);
    void deletaClienteAtravesId(UUID idCliente);
    void patchAlteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);
}
