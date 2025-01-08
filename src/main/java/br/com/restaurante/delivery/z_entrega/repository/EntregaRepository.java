package br.com.restaurante.delivery.z_entrega.repository;

import br.com.restaurante.delivery.z_entrega.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EntregaRepository  {
    Entrega save(Entrega entrega);
    List<Entrega> findyAll();
    List<Entrega> buscaEntregaPorPedido(String idPedido);
    void delete(Entrega entrega);
    Optional<Entrega> findById(UUID idEntrega);
}
