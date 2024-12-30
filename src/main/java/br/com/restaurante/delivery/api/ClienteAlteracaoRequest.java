package br.com.restaurante.delivery.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class ClienteAlteracaoRequest {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String endereco;
    private String celular;
    private String telefone;
    private String sexo;
    @NotNull
    private LocalDate dataNascimento;
    private LocalDateTime dataHoraDoCadastro;
}
