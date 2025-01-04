package br.com.restaurante.delivery.z_pedido.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PedidoRequest {
    @NotBlank
     String nomeRefeicao;
     String nomeBebida;
     String observacaoPedido;

    private LocalDateTime dataHoraDoCadastro;
}
