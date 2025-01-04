package br.com.restaurante.delivery.z_pedido.repository;

import br.com.restaurante.delivery.domain.Cliente;
import br.com.restaurante.delivery.z_pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PedidoInfraRepository implements PedidoRepository{
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
}
