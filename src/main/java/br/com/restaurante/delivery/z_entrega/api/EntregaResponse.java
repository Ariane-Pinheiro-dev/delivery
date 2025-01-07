package br.com.restaurante.delivery.z_entrega.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class EntregaResponse {
    UUID idEntrega;
    String nomeCompletoCliente;
    String endereco;
    String celular;
    String nomeRefeicao;
    String nomeBebida;
    double valor;

}
