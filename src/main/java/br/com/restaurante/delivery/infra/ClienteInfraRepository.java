package br.com.restaurante.delivery.infra;

import br.com.restaurante.delivery.domain.Cliente;
import br.com.restaurante.delivery.handler.APIException;
import br.com.restaurante.delivery.repostory.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;
    private Cliente cliente;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        clienteSpringDataJPARepository.save(cliente);
        log.info("[finaliza] ClienteInfraRepository - salva");
        return cliente;
    }

    @Override
    public List<Cliente> buscaTodosClientes() {
        log.info("[inicia] ClienteInfraRepository - buscaTodosClientes");
        List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
        log.info("[finaliza] ClienteInfraRepository - buscaTodosClientes");
        return todosClientes;
    }

    @Override
    public Cliente buscaClienteAtravesId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - buscaClienteAtravesId");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        log.info("[finaliza] ClienteInfraRepository - buscaClienteAtravesId");
        return cliente;
    }

    @Override
    public void deletaCliente(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - deletaCliente");
        clienteSpringDataJPARepository.delete(cliente);
        log.info("[finaliza] ClienteInfraRepository - deletaCliente");
    }
}
