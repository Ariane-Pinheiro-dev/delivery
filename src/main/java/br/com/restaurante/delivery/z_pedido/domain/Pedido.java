package br.com.restaurante.delivery.z_pedido.domain;

import br.com.restaurante.delivery.domain.Cliente;
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
    @Column(columnDefinition = "uuid", name = "idPedido", updatable = false, unique = true, nullable = false)
    private UUID idPedido;
    @NotNull
    @Column(columnDefinition = "uuid", name = "idClienteDelivery", nullable = false)
    private UUID idClienteDelivery;
    @NotBlank
    private String nomeRefeicao;
    private String nomeBebida;
    private String observacaoPedido;

    private LocalDateTime dataHoraDoPedido;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Pedido(UUID idClienteDelivery, String nomeRefeicao, String nomeBebida, String observacaoPedido, double valor) {
        this.idClienteDelivery = idClienteDelivery;
        this.nomeRefeicao = nomeRefeicao;
        this.nomeBebida = nomeBebida;
        this.observacaoPedido = observacaoPedido;
        this.valor = valor;
        this.dataHoraDoPedido = LocalDateTime.now();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "idClienteDelivery", insertable = false, updatable = false)
    private Cliente cliente;
    private String descricao;
    private double valor;

    public Pedido(Cliente cliente, String descricao, Cardapio cardapio) {
        if (cliente == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }
        if (cardapio == null || !cardapio.contemItem(descricao)) {
            throw new IllegalArgumentException("O item solicitado não está disponível no cardápio.");
        }
        this.cliente = cliente;
        this.descricao = descricao;
        this.valor = cardapio.getPrecoPorItem(descricao);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
