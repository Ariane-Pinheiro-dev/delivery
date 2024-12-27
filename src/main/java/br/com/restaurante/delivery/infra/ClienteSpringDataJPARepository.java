package br.com.restaurante.delivery.infra;

import br.com.restaurante.delivery.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClienteSpringDataJPARepository extends JpaRepository<Cliente, UUID> {
    Optional<Cliente> findByIdCliente(UUID idCliente);
}
