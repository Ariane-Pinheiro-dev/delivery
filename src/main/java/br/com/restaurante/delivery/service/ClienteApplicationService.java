package br.com.restaurante.delivery.service;

import br.com.restaurante.delivery.api.ClienteDetalhadoResponse;
import br.com.restaurante.delivery.api.ClienteListResponse;
import br.com.restaurante.delivery.api.ClienteRequest;
import br.com.restaurante.delivery.api.ClienteResponse;
import br.com.restaurante.delivery.domain.Cliente;
import br.com.restaurante.delivery.infra.ClienteInfraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    private final ClienteInfraRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[Start] ClienteService.criaCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[Finish] ClienteService.criaCliente");
        return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();

    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[Start] ClienteService.buscaTodosClientes");
        List<Cliente> clientes = clienteRepository.buscaTodosClientes();
        log.info("[Finish] ClienteService.buscaTodosClientes");
        return ClienteListResponse.converte(clientes);
    }

    @Override
    public ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente) {
        log.info("[Start] ClienteService.buscaClienteAtravesId");
        Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
        log.info("[Finish] ClienteService.buscaClienteAtravesId");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void deletaClienteAtravesId(UUID idCliente) {
        log.info("[Start] ClienteService.deletaClienteAtravesId");
        Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
        clienteRepository.deletaCliente(cliente);
        log.info("[Finish] ClienteService.deletaClienteAtravesId");

    }
}
