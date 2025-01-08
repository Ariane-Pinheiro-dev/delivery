package br.com.restaurante.delivery.z_entrega.repository;

import br.com.restaurante.delivery.y_pedido.domain.Pedido;
import br.com.restaurante.delivery.z_entrega.domain.Entrega;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EntregaInfraRepository implements EntregaRepository {
    private final EntregaSpringDataJPARepository entregaSpringDataJPARepository;

    @Override
    public Entrega save(Entrega entrega) {
        log.info("[start] EntregaInfraRepository - salvaEntrega");
        entregaSpringDataJPARepository.save(entrega);
        log.info("[finish] EntregaInfraRepository - salvaEntrega");
        return entrega;
    }

    @Override
    public List<Entrega> findyAll() {
        log.info("[start] EntregaInfraRepository - buscaTodasEntregas");
        List<Entrega> todasEntregas = entregaSpringDataJPARepository.findAll();
        log.info("[finish] EntregaInfraRepository - buscaTodasEntregas");
        return todasEntregas;

    }

    @Override
    public List<Entrega> buscaEntregaPorPedido(String idPedido) {
        log.info("[start] EntregaInfraRepository - buscaEntregaPorPedido");
        log.info("[idPedido] {}", idPedido);
        UUID idPedidoUUID = UUID.fromString(idPedido);
        List<Entrega> entregasPedidos = entregaSpringDataJPARepository.findByIdPedido(idPedidoUUID);
        log.info("[finish] EntregaInfraRepository - buscaEntregaPorPedido - Total de entregas encontradas: {}", entregasPedidos.size());
        return entregasPedidos;
    }

    @Override
    public void delete(Entrega entrega) {
        log.info("[start] EntregaInfraRepository - deletaEntrega - Entrega ID: {}", entrega.getIdEntrega());
        entregaSpringDataJPARepository.delete(entrega);
        log.info("[finish] EntregaInfraRepository - deletaEntrega - Entrega ID: {}", entrega.getIdEntrega());
    }

    @Override
    public Optional<Entrega> findById(UUID idEntrega) {
        log.info("[start] EntregaInfraRepository - findById");
        Optional<Entrega> entrega = entregaSpringDataJPARepository.findById(idEntrega);
        if (entrega.isPresent()) {
            log.info("[finish] EntregaInfraRepository - Entrega encontrada: {}", entrega.get().getIdEntrega());
        } else {
            log.info("[finish] EntregaInfraRepository - Entrega não encontrada.");
        }
        return entrega;
    }
}
