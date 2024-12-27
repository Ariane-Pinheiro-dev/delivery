package br.com.restaurante.delivery.api;

import br.com.restaurante.delivery.domain.Cliente;
import lombok.Value;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String endereco;
    private String celular;
    private String telefone;
    private String sexo;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;

    public static List<ClienteListResponse> converte(List<Cliente> clientes) {
        return clientes.stream()
                .map(ClienteListResponse::new)
                .collect(Collectors.toList());
    }

    private ClienteListResponse(Cliente cliente){
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
