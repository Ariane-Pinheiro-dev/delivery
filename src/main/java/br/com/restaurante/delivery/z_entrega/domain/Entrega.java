package br.com.restaurante.delivery.z_entrega.domain;

import br.com.restaurante.delivery.domain.Cliente;
import br.com.restaurante.delivery.y_pedido.domain.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idEntrega", updatable = false, unique = true, nullable = false)
    private UUID idEntrega;

    @NotNull
    @Column(columnDefinition = "uuid", name = "idPedido", nullable = false)
    private UUID idPedido;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    private String endereco;
    @NotBlank
    private String celular;
    @NotBlank
    private String nomeRefeicao;
    @NotBlank
    private String nomeBebida;
    private double valor;

    @ManyToOne
    @JoinColumn(name = "idPedido", insertable = false, updatable = false)
    private Pedido pedido;


    public Entrega(UUID idPedido, String nomeCompleto, String endereco, String celular, String nomeRefeicao, String nomeBebida, double valor) {
        this.idPedido = idPedido;
        this.nomeCompleto = nomeCompleto;
        this.endereco = endereco;
        this.celular = celular;
        this.nomeRefeicao = nomeRefeicao;
        this.nomeBebida = nomeBebida;
        this.valor = valor;
    }
}

