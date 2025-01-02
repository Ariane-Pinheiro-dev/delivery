package br.com.restaurante.delivery.pedido.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pedido")
public interface PedidoAPI {

}
