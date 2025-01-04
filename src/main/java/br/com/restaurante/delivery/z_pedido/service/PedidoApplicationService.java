package br.com.restaurante.delivery.z_pedido.service;

import br.com.restaurante.delivery.service.ClienteService;
import br.com.restaurante.delivery.z_pedido.api.PedidoRequest;
import br.com.restaurante.delivery.z_pedido.api.PedidoResponse;
import br.com.restaurante.delivery.z_pedido.domain.Cardapio;
import br.com.restaurante.delivery.z_pedido.domain.Pedido;
import br.com.restaurante.delivery.z_pedido.repository.PedidoRepository;
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
    private final Cardapio cardapio;

    @Override
    public PedidoResponse criaPedido(UUID idCliente, @Valid PedidoRequest pedidoRequest) {
        log.info("[Start] PedidoApplicationService - criaPedido");
        if (!cardapio.contemItem(pedidoRequest.getNomeRefeicao())) {
            throw new IllegalArgumentException("Refeição não encontrada no cardápio.");
        }
        if (pedidoRequest.getNomeBebida() != null && !cardapio.contemItem(pedidoRequest.getNomeBebida())) {
            throw new IllegalArgumentException("Bebiba não encontrada no cardápio.");
        }
        clienteService.buscaClienteAtravesId(idCliente);
        double valorRefeicao = cardapio.obterValorItem(pedidoRequest.getNomeRefeicao());
        double valorBebida = pedidoRequest.getNomeBebida() != null
                ? cardapio.obterValorItem(pedidoRequest.getNomeBebida())
                : 0.0;
        double valorTotal = valorRefeicao + valorBebida;

        Pedido pedido = new Pedido(
                idCliente,
                pedidoRequest.getNomeRefeicao(),
                pedidoRequest.getNomeBebida(),
                pedidoRequest.getObservacaoPedido(),
                valorTotal);

        pedido = pedidoRepository.save(pedido);
        log.info("[Finish] PedidoApplicationService.criaPedido");
        return new PedidoResponse(
                pedido.getIdPedido(),
                pedido.getNomeRefeicao(),
                pedido.getNomeBebida(),
                pedido.getValor(),
                pedido.getObservacaoPedido());
    }
}

