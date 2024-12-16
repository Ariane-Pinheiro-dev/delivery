package br.com.restaurante.delivery.api;

import br.com.restaurante.delivery.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ClienteController implements ClienteAPI {
    private static final Logger LOGGER = Logger.getLogger(ClienteController.class.getName());
    private ClienteService clienteService;

    @Override
    public ClienteResponse postCliente(ClienteRequest clienteRequest) {
        LOGGER.info("Inicia ClienteController - postCliente");
        LOGGER.info("Finaliza ClienteController - postCliente");
        return null;
    }
}