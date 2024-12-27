package br.com.restaurante.delivery.repostory;

import br.com.restaurante.delivery.domain.Cliente;


public interface ClienteRepository {
    Cliente salva(Cliente cliente);
}
