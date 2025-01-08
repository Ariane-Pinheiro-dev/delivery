package br.com.restaurante.delivery.z_entrega.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EntregaAlteracaoRequest {

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
