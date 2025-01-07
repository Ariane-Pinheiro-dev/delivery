package br.com.restaurante.delivery.y_pedido.domain;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Cardapio {
    private Map<String, Double> itens; //armazena itens

    public Cardapio() {
        itens = new HashMap<>();
        itens.put("X-tudo", 25.00);
        itens.put("X-salada", 20.00);
        itens.put("Hamburguer", 15.00);
        itens.put("Misto quente", 9.00);
        itens.put("Coca cola 2L", 10.00);
        itens.put("Kuat 1L", 7.00);
        itens.put("Pepsi lata", 5.00);

    }

    public double obterValorItem(String item) {
        return itens.getOrDefault(item, 0.0);
    }

    public Map<String, Double> getItens() {
        return itens;
    }

    public boolean contemItem(String descricao) {
        // Verifica se o item está presente no cardápio
        return this.itens.containsKey(descricao);
    }

    public double getPrecoPorItem(String nomeItem) {
        if ("X-tudo".equals(nomeItem)) {
            return 25.00;
        } else if ("Coca Cola 2L".equals(nomeItem)) {
            return 10.00;
        } else {
            throw new IllegalArgumentException("Item não encontrado no cardápio.");
        }
    }
}

