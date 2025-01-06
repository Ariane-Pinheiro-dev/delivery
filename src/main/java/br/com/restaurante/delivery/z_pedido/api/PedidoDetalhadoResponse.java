package br.com.restaurante.delivery.z_pedido.api;

import br.com.restaurante.delivery.z_pedido.domain.Pedido;
import lombok.Value;

import java.util.UUID;

@Value
public class PedidoDetalhadoResponse {
    private UUID idPedido;
    private String nomeCliente;
    private String nomeRefeicao;
    private String nomeBebida;
    private String observacaoPedido;
    private double valor;

    public PedidoDetalhadoResponse(Pedido pedido) {
        this.idPedido = getIdPedido();
        this.nomeCliente = getNomeCliente();
        this.nomeRefeicao = getNomeRefeicao();
        this.nomeBebida = getNomeBebida();
        this.observacaoPedido = getObservacaoPedido();
        this.valor = getValor();
    }
}
