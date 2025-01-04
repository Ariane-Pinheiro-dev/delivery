package br.com.restaurante.delivery.z_pedido.api;

import br.com.restaurante.delivery.z_pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PedidoController implements PedidoAPI {
    private final PedidoService pedidoService;

    @Override
    public PedidoResponse postPedido(UUID idCliente, PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoController - postPedido");
        log.info("[idCliente] {}", idCliente);
        PedidoResponse pedido = pedidoService.criaPedido(idCliente, pedidoRequest);
        log.info("[finaliza] PedidoController - postPedido");
        return pedido;
    }
    @Override
    public List<PedidoListResponse>getTodosPedidos(){
        log.info("[inicia] PedidoController - getTodosPedidos");
        List<PedidoListResponse> pedidos = pedidoService.buscaTodosPedidos();
        log.info("[finaliza] PedidoController - getTodosPedidos");
        return pedidos;
    }
}
