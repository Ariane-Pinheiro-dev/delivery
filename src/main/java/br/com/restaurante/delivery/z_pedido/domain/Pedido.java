package br.com.restaurante.delivery.z_pedido.domain;

import br.com.restaurante.delivery.domain.Cliente;
import br.com.restaurante.delivery.z_pedido.api.PedidoRequest;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    private Cliente cliente;
    private String descricao;
    private double valor;

    public Pedido(Cliente cliente, String descricao, double valor) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idPedido", updatable = false, unique = true, nullable = false)
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

    public Pedido(UUID idClienteDelivery, @Valid PedidoRequest pedidoRequest) {
        this.idClienteDelivery = idClienteDelivery;
        this.nomeRefeicao = pedidoRequest.getNomeRefeicao();
        this.preferenciasPedido = pedidoRequest.getPreferenciasPedido();
        this.nomeBebiba = pedidoRequest.getNomeBebida();
        this.dataHoraDoPedido = LocalDateTime.now();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}
