package br.com.restaurante.delivery.z_entrega.service;

import br.com.restaurante.delivery.y_pedido.api.PedidoListResponse;
import br.com.restaurante.delivery.y_pedido.domain.Cardapio;
import br.com.restaurante.delivery.y_pedido.domain.Pedido;
import br.com.restaurante.delivery.y_pedido.service.PedidoService;
import br.com.restaurante.delivery.z_entrega.api.EntregaListResponse;
import br.com.restaurante.delivery.z_entrega.api.EntregaRequest;
import br.com.restaurante.delivery.z_entrega.api.EntregaResponse;
import br.com.restaurante.delivery.z_entrega.domain.Entrega;
import br.com.restaurante.delivery.z_entrega.repository.EntregaRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class EntregaApplicationService implements EntregaService {
    private final PedidoService pedidoService;
    private final EntregaRepository entregaRepository;
    private final Cardapio cardapio;

    @Override
    public EntregaResponse criaEntrega(UUID idPedido, @Valid EntregaRequest entregaRequest) {
        log.info("[Start] EntregaApplicationService - criaEntrega");
        if (!cardapio.contemItem(entregaRequest.getNomeRefeicao())) {
            throw new IllegalArgumentException("Refeição não encontrada no cardápio.");
        }
        if (entregaRequest.getNomeBebida() != null && !cardapio.contemItem(entregaRequest.getNomeBebida())) {
            throw new IllegalArgumentException("Bebiba não encontrada no cardápio.");
        }
        Pedido pedido = pedidoService.buscaPedidoAtravesId(idPedido);
        double valorRefeicao = cardapio.obterValorItem(entregaRequest.getNomeRefeicao());
        double valorBebida = entregaRequest.getNomeBebida() != null
                ? cardapio.obterValorItem(entregaRequest.getNomeBebida())
                : 0.0;
        double valorTotal = valorRefeicao + valorBebida;

        Entrega entrega = new Entrega(
                idPedido,
                entregaRequest.getNomeCompleto(),
                entregaRequest.getEndereco(),
                entregaRequest.getCelular(),
                entregaRequest.getNomeRefeicao(),
                entregaRequest.getNomeBebida(),
                valorTotal);
        
        entrega = entregaRepository.save(entrega);
        log.info("[Finish] EntregaApplicationService.criaEntrega");
        return new EntregaResponse(
                entrega.getIdEntrega(),
                entrega.getNomeCompleto(),
                entrega.getEndereco(),
                entrega.getCelular(),
                entrega.getNomeRefeicao(),
                entrega.getNomeBebida(),
                entrega.getValor());
    }

    @Override
    public List<EntregaListResponse> buscaTodasEntregas() {
        log.info("[Start] EntregaService.buscaTodasEntregas");
        List<Entrega> entregas = entregaRepository.findyAll();
        log.info("[Finish] EntregaService.buscaTodasEntregas");
        return EntregaListResponse.converte(entregas);
    }
}
