package br.com.restaurante.delivery.z_entrega.service;

import br.com.restaurante.delivery.z_entrega.api.EntregaRequest;
import br.com.restaurante.delivery.z_entrega.api.EntregaResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface EntregaService {
    EntregaResponse criaEntrega(UUID idPedido, @Valid EntregaRequest entregaRequest);
}
