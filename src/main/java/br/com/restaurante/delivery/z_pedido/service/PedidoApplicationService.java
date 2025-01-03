package br.com.restaurante.delivery.z_pedido.service;

import br.com.restaurante.delivery.z_pedido.api.PedidoRequest;
import br.com.restaurante.delivery.z_pedido.api.PedidoResponse;
import br.com.restaurante.delivery.z_pedido.domain.Pedido;
import br.com.restaurante.delivery.z_pedido.repository.PedidoRepository;
import br.com.restaurante.delivery.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PedidoApplicationService implements PedidoService {
    private final ClienteService clienteService;
    private final PedidoRepository pedidoRepository;

    public PedidoResponse criaPedido(UUID idCliente, @Valid PedidoRequest pedidoRequest) {
        log.info("[Start] PedidoApplicationService - criaPedido");
        clienteService.buscaClienteAtravesId(idCliente);
        Pedido pedido = pedidoRepository.salvaPedido(new Pedido(idCliente, pedidoRequest));
        log.info("[Finish] PedidoApplicationService.criaPedido");
        return new PedidoResponse(pedido.getIdPedido());
    }
}
