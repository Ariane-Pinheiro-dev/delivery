package br.com.restaurante.delivery.pedido;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    private String nomeRefeicao;
    private String nomeBebiba;
    private String preferenciasPedido;

    private LocalDateTime dataHoraDoPedido;
    private LocalDateTime dataHoraDaUltimaAlteracao;
}
