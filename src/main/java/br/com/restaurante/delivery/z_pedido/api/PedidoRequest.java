package br.com.restaurante.delivery.z_pedido.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class PedidoRequest {

    @NotBlank
    private String nomePedido;
    private String nomeBebida;
    private String prefenciaPedido;

    private LocalDateTime dataHoraDoCadastro;
}
