package br.com.restaurante.delivery.y_pedido.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PedidoAlteracaoRequest {

    @NotBlank
    private String nomeRefeicao;
    private String nomeBebida;
    private String observacaoPedido;

    private LocalDateTime dataHoraDaUltimaAlteracao;
}
