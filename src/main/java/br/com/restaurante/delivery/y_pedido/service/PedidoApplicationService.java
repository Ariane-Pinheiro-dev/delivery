package br.com.restaurante.delivery.y_pedido.service;

import br.com.restaurante.delivery.service.ClienteService;
import br.com.restaurante.delivery.y_pedido.api.PedidoAlteracaoRequest;
import br.com.restaurante.delivery.y_pedido.api.PedidoListResponse;
import br.com.restaurante.delivery.y_pedido.api.PedidoRequest;
import br.com.restaurante.delivery.y_pedido.api.PedidoResponse;
import br.com.restaurante.delivery.y_pedido.domain.Cardapio;
import br.com.restaurante.delivery.y_pedido.domain.Pedido;
import br.com.restaurante.delivery.y_pedido.repository.PedidoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

    @Override
    public List<PedidoListResponse> buscaTodosPedidos() {
        log.info("[Start] PedidoService.buscaTodosPedidos");
        List<Pedido> pedidos = pedidoRepository.findyAll();
        log.info("[Finish] PedidosService.buscaTodosPedidos");
        return PedidoListResponse.converte(pedidos);
    }

    @Override
    public List<PedidoListResponse> buscarPedidosPorCliente(UUID idCliente) {
        log.info("[Start] PedidoApplicationService - buscarPedidosPorCliente");
        log.info("[idCliente] {}", idCliente);
        clienteService.buscaClienteAtravesId(idCliente);
        List<Pedido> pedidos = pedidoRepository.buscaPedidosPorCliente(idCliente.toString());
        log.info("[Finish] PedidoApplicationService - buscarPedidosPorCliente - Total de pedidos encontrados: {}", pedidos.size());
        return PedidoListResponse.converte(pedidos);
    }

    @Override
    public void deletaPedidoDoClienteComId(UUID idPedido, UUID idCliente) {
        log.info("[Start] PedidoApplicationService - deletaPedido");
        log.info("[idPedido] {} - [idCliente] {}", idPedido, idCliente);
        clienteService.buscaClienteAtravesId(idCliente);
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
        if (!pedido.getIdClienteDelivery().equals(idCliente)) {
            throw new IllegalArgumentException("O pedido não pertence ao cliente informado");
        }
        pedidoRepository.delete(pedido);
        log.info("[Finish] PedidoApplicationService - deletaPedido");
    }

    @Override
    public void alteraPedidoDoClienteComID(UUID idCliente, UUID idPedido, PedidoAlteracaoRequest pedidoAlteracaoRequest) {
        log.info("[start] PedidoApplicationService - alteraPedidoDoClienteComID");
        Pedido pedido = pedidoRepository.findById(idPedido)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
        pedido.altera(pedidoAlteracaoRequest);
        pedidoRepository.save(pedido);
        log.info("[finaliza] PedidoApplicationService - alteraPedidoDoClienteComID");
    }
}



