package br.com.restaurante.delivery.z_entrega.repository;

import br.com.restaurante.delivery.z_entrega.domain.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EntregaRepository  {
    Entrega save(Entrega entrega);
}
