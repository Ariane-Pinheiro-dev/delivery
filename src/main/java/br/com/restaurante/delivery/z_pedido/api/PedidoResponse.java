package br.com.restaurante.delivery.z_pedido.api;


import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PedidoResponse {
    UUID idPedido;
    String nomeRefeicao;
    String nomeBebida;
    double valor;
    String observacaoPedido;

    public PedidoResponse(UUID idPedido, String nomeRefeicao, String nomeBebida, double valor, String observacaoPedido) {
        this.idPedido = idPedido;
        this.nomeRefeicao = nomeRefeicao;
        this.nomeBebida = nomeBebida;
        this.valor = valor;
        this.observacaoPedido = observacaoPedido;
    }
}

