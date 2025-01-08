package br.com.restaurante.delivery.z_entrega.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.util.UUID;

@Value
public class EntregaRequest {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String endereco;
    @NotBlank
    private String celular;
    @NotBlank
    private String nomeRefeicao;
    private String nomeBebida;
    private double valor;

}
