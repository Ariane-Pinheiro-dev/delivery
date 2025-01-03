package br.com.restaurante.delivery.z_pedido.api;

import br.com.restaurante.delivery.z_pedido.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PedidoController implements PedidoAPI {
    private final PedidoService pedidoService;

    @Override
    public PedidoResponse postPedido(PedidoRequest pedidoRequest) {
        return null;
    }
}
