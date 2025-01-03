package br.com.restaurante.delivery.z_pedido.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pedido")
public interface PedidoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidoResponse postPedido(@Valid @RequestBody PedidoRequest pedidoRequest);

}
