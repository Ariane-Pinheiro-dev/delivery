package br.com.restaurante.delivery.z_pedido.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
    private UUID idPedido;
    @NotNull
    @Column(columnDefinition = "uuid", name = "idClienteDelivery", nullable = false)
    private UUID idClienteDelivery;
    @NotBlank
    private String nomeRefeicao;
    private String nomeBebiba;
    private String preferenciasPedido;

    private LocalDateTime dataHoraDoPedido;
    private LocalDateTime dataHoraDaUltimaAlteracao;
}
