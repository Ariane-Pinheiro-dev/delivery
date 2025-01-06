package br.com.restaurante.delivery.z_pedido.api;

import br.com.restaurante.delivery.z_pedido.domain.Pedido;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoListResponse {
    private UUID idPedido;
    private String nomeCliente;
    private String nomeRefeicao;
    private String nomeBebida;
    private String observacaoPedido;
    private double valor;

    public PedidoListResponse(Pedido pedido) {
        if (pedido != null) {
            this.idPedido = pedido.getIdPedido();
            this.nomeCliente = pedido.getCliente() != null ? pedido.getCliente().getNome() : "Desconhecido";
            this.nomeRefeicao = pedido.getNomeRefeicao();
            this.nomeBebida = pedido.getNomeBebida();
            this.observacaoPedido = pedido.getObservacaoPedido();
            this.valor = pedido.getValor();
        } else {
            this.idPedido = null;  // ou algum valor padrão
            this.nomeCliente = "Desconhecido";
            this.nomeRefeicao = "";
            this.nomeBebida = "";
            this.observacaoPedido = "";
            this.valor = 0.0;
        }
    }

    public static List<PedidoListResponse> converte(List<Pedido> pedidos) {
        return pedidos.stream()
                .map(PedidoListResponse::new)
                .collect(Collectors.toList());
    }

    public UUID getIdPedido() {
        return idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }

    public String getNomeBebida() {
        return nomeBebida;
    }

    public String getObservacaoPedido() {
        return observacaoPedido;
    }

    public double getValor() {
        return valor;
    }
}