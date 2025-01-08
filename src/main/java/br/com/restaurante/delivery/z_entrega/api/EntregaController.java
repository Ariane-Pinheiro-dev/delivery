package br.com.restaurante.delivery.z_entrega.api;

import br.com.restaurante.delivery.y_pedido.api.PedidoListResponse;
import br.com.restaurante.delivery.y_pedido.api.PedidoRequest;
import br.com.restaurante.delivery.y_pedido.api.PedidoResponse;
import br.com.restaurante.delivery.z_entrega.service.EntregaApplicationService;
import br.com.restaurante.delivery.z_entrega.service.EntregaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EntregaController implements EntregaAPI {
    private final EntregaService entregaService;

    @Override
    public EntregaResponse postEntrega(UUID idPedido, EntregaRequest entregaRequest) {
        log.info("[inicia] EntregaController - postEntrega");
        log.info("[idPedido] {}", idPedido);
        EntregaResponse entrega = entregaService.criaEntrega(idPedido, entregaRequest);
        log.info("[finaliza] EntregaController - postEntrega");
        return entrega;
    }

    @Override
    public List<EntregaListResponse> getTodasEntregas() {
        log.info("[inicia] EntregaController - getTodasEntregas");
        List<EntregaListResponse> entrega = entregaService.buscaTodasEntregas();
        log.info("[finaliza] EntregaController - getTodasEntregas");
        return entrega;
    }

    @Override
    public List<EntregaListResponse> getEntregaPorPedido(UUID idPedido) {
        log.info("[inicia] EntregaController - getEntregasPorPedido");
        log.info("[idPedido] {}", idPedido);
        List<EntregaListResponse> entregas = entregaService.buscarEntregasPorPedido(idPedido);
        log.info("[finaliza] EntregaController - getEntregasPorPedido - Total de entregas encontrados: {}", entregas.size());
        return entregas;
    }
}
