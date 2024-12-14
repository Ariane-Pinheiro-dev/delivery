package br.com.restaurante.delivery.api;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Value
public class ClienteRequest {
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String endereco;
    private String celular;
    private String telefone;
    private String sexo;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @CPF
    @NotBlank
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private Boolean aceitaTermos;

}
