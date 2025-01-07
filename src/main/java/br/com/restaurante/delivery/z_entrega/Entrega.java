package br.com.restaurante.delivery.z_entrega;

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
    private String nomeCompletoCliente;
    @NotBlank
    private String endereco;
    private String celular;


}
