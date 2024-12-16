package br.com.restaurante.delivery.service;

import br.com.restaurante.delivery.api.ClienteRequest;
import br.com.restaurante.delivery.api.ClienteResponse;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);
}
