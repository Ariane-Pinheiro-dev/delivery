package br.com.restaurante.delivery.z_entrega.api;

import br.com.restaurante.delivery.y_pedido.api.PedidoListResponse;
import br.com.restaurante.delivery.y_pedido.domain.Pedido;
import br.com.restaurante.delivery.z_entrega.domain.Entrega;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class EntregaListResponse {

    @JsonProperty("idEntrega")
    private UUID idEntrega;
    @JsonProperty("nomeCompleto")
    private String nomeCompleto;
    @JsonProperty("endereco")
    private String endereco;
    @JsonProperty("celular")
    private String celular;
    @JsonProperty("nomeRefeicao")
    private String nomeRefeicao;
    @JsonProperty("nomeBebida")
    private String nomeBebida;
    @JsonProperty("valor")
    private double valor;
    public EntregaListResponse() {
    }
    public EntregaListResponse(Entrega entrega) {
        this.idEntrega = entrega.getIdEntrega();
        this.nomeCompleto = entrega.getNomeCompleto();
        this.endereco = entrega.getEndereco();
        this.celular = entrega.getCelular();
        this.nomeRefeicao = entrega.getNomeRefeicao();
        this.nomeBebida = entrega.getNomeBebida();
        this.valor = entrega.getValor();
    }

    public UUID getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(UUID idEntrega) {
        this.idEntrega = idEntrega;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }

    public void setNomeRefeicao(String nomeRefeicao) {
        this.nomeRefeicao = nomeRefeicao;
    }

    public String getNomeBebida() {
        return nomeBebida;
    }

    public void setNomeBebida(String nomeBebida) {
        this.nomeBebida = nomeBebida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public static List<EntregaListResponse> converte(List<Entrega> entregas) {
        return entregas.stream()
                .map(EntregaListResponse::new)
                .collect(Collectors.toList());
    }
}
