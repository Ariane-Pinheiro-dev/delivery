package br.com.restaurante.delivery.z_pedido.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PedidoRequest {
    @NotBlank
    private String nomeRefeicao;
    private String nomeBebida;
    private String preferenciasPedido;

    private LocalDateTime dataHoraDoCadastro;
}
