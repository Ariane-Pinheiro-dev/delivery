package br.com.restaurante.delivery.z_entrega.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EntregaRequest {
    @NotBlank
    private String nomeCompletoCliente;
    private String endereco;
    private String celular;
}
