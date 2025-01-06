package br.com.restaurante.delivery.z_pedido.repository;

import br.com.restaurante.delivery.z_pedido.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PedidoSpringDataJPARepository extends JpaRepository<Pedido, UUID> {
    List<Pedido> findAll();
    List<Pedido> findByIdClienteDelivery(UUID idClienteDelivery);
}

