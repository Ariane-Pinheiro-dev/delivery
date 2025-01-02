package br.com.restaurante.delivery.pedido.service;

import br.com.restaurante.delivery.api.ClienteRequest;
import br.com.restaurante.delivery.api.ClienteResponse;
import br.com.restaurante.delivery.domain.Cliente;
import br.com.restaurante.delivery.pedido.api.PedidoRequest;
import br.com.restaurante.delivery.pedido.api.PedidoResponse;
import br.com.restaurante.delivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PedidoApplicationService implements PedidoService {

    @Override
    public PedidoResponse criaPedido(PedidoRequest PedidoRequest) {
        log.info("[Start] PedidoService.criaPedido");
        Pedido pedido = pedidoRepository.salva(new Pedido(pedidoRequest));
        log.info("[Finish] PedidoService.criaPedido");
        return PedidoResponse.builder().idPedido(pedido.getIdPedido()).build();

}
