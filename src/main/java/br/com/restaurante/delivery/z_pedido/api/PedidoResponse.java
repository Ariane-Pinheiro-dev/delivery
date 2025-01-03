package br.com.restaurante.delivery.z_pedido.api;


import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PedidoResponse {

    private UUID idPedido;
}
