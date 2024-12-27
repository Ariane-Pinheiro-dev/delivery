package br.com.restaurante.delivery.service;

import br.com.restaurante.delivery.api.ClienteRequest;
import br.com.restaurante.delivery.api.ClienteResponse;
import br.com.restaurante.delivery.domain.Cliente;
import br.com.restaurante.delivery.repostory.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[Start] ClienteApplicationService - criaCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[Finish] ClienteApplicationService - criaCliente");
        return ClienteResponse.builder()
                .idCliente(cliente != null ? cliente.getIdCliente(): null)
                .build();
    }
}
