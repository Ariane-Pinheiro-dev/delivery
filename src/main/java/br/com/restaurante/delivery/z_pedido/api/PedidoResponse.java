package br.com.restaurante.delivery.z_pedido.api;


import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
public class PedidoResponse {
    private UUID idPedido;
}
