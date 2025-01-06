package br.com.restaurante.delivery.z_pedido.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/pedidos")
public interface PedidoAPI {

    @PostMapping("/{idCliente}")
    @ResponseStatus(code = HttpStatus.CREATED)
    PedidoResponse postPedido(@PathVariable UUID idCliente,
                              @Valid @RequestBody PedidoRequest pedidoRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PedidoListResponse> getTodosPedidos();

    @GetMapping(value = "/{idPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    List<PedidoListResponse> getPedidosPorCliente(@PathVariable UUID idCliente);
}
