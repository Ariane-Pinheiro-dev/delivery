package br.com.restaurante.delivery.z_pedido.repository;

import br.com.restaurante.delivery.z_pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PedidoInfraRepository implements PedidoRepository {
    private final PedidoSpringDataJPARepository pedidoSpringDataJPARepository;

    @Override
    public Pedido save(Pedido pedido) {
        log.info("[start] PedidoInfraRepository - salvaPedido");
        pedidoSpringDataJPARepository.save(pedido);
        log.info("[finish] PedidoInfraRepository - salvaPedido");
        return pedido;
    }

    @Override
    public List<Pedido> findyAll() {
        log.info("[inicia] PedidoInfraRepository - buscaTodosPedidos");
        List<Pedido> todosPedidos = pedidoSpringDataJPARepository.findAll();
        log.info("[finaliza] PedidoInfraRepository - buscaTodosPedidos");
        return todosPedidos;
    }

    @Override
    public List<Pedido> buscaPedidosPorCliente(String idCliente) {
        log.info("[start] PedidoInfraRepository - buscaPedidosPorCliente");
        log.info("[idCliente] {}", idCliente);

        // Convertendo o idCliente para UUID
        UUID idClienteUUID = UUID.fromString(idCliente);

        // Buscando pedidos por idClienteDelivery
        List<Pedido> pedidosCliente = pedidoSpringDataJPARepository.findByIdClienteDelivery(idClienteUUID);

        log.info("[finish] PedidoInfraRepository - buscaPedidosPorCliente - Total de pedidos encontrados: {}", pedidosCliente.size());
        return pedidosCliente;
    }
}

