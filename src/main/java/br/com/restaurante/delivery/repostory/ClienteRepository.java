package br.com.restaurante.delivery.repostory;

import br.com.restaurante.delivery.domain.Cliente;

import java.util.List;
import java.util.UUID;


public interface ClienteRepository {
    Cliente salva(Cliente cliente);
    List<Cliente> buscaTodosClientes();
    Cliente buscaClienteAtravesId(UUID idCliente);
}
