package br.com.restaurante.delivery.api;

import br.com.restaurante.delivery.domain.Cliente;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String endereco;
    private String celular;
    private String telefone;
    private String sexo;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;

    public ClienteDetalhadoResponse(Cliente cliente) {
        super();
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.endereco = cliente.getEndereco();
        this.celular = cliente.getCelular();
        this.telefone = cliente.getTelefone();
        this.sexo = cliente.getSexo();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
    }
}
