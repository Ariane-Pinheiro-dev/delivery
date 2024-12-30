package br.com.restaurante.delivery.api;

import br.com.restaurante.delivery.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
    private final ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteController - postCliente");
        ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
        log.info("[finaliza] ClienteController - postCliente");
        return clienteCriado;
    }
    @Override
    public List<ClienteListResponse> getTodosClientes(){
        log.info("[inicia] ClienteController - getTodosClientes");
        List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
        log.info("[finaliza] ClienteController - getTodosClientes");
        return clientes;
    }
    @Override
    public ClienteDetalhadoResponse getClienteAtravesId(UUID idCliente) {
        log.info("[inicia] ClienteController - getClienteAtravesId");
        log.info("[idCliente] {}", idCliente);
        ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClienteAtravesId(idCliente);
        log.info("[finaliza] ClienteController - getClienteAtravesId");
        return clienteDetalhado;
    }
}