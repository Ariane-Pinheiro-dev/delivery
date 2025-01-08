package br.com.restaurante.delivery.z_entrega.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder
@Value
public class EntregaResponse {
    UUID idEntrega;
    String nomeCompleto;
    String endereco;
    String celular;
    String nomeRefeicao;
    String nomeBebida;
    double valor;

    public EntregaResponse(UUID idEntrega, String nomeCompleto, String endereco, String celular, String nomeRefeicao, String nomeBebida, double valor) {
        this.idEntrega = idEntrega;
        this.nomeCompleto = nomeCompleto;
        this.endereco = endereco;
        this.celular = celular;
        this.nomeRefeicao = nomeRefeicao;
        this.nomeBebida = nomeBebida;
        this.valor = valor;
    }
}

