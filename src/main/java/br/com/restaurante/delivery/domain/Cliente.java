package br.com.restaurante.delivery.domain;

import br.com.restaurante.delivery.api.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
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
    @Column(unique = true)
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private Boolean aceitaTermos;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.endereco = clienteRequest.getEndereco();
        this.celular = clienteRequest.getCelular();
        this.telefone = clienteRequest.getTelefone();
        this.sexo = clienteRequest.getSexo();
        this.email = clienteRequest.getEmail();
        this.cpf = clienteRequest.getCpf();
        this.aceitaTermos = clienteRequest.getAceitaTermos();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}




