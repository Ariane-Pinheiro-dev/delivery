package br.com.restaurante.delivery.z_entrega.api;

import br.com.restaurante.delivery.y_pedido.api.PedidoListResponse;
import br.com.restaurante.delivery.y_pedido.api.PedidoRequest;
import br.com.restaurante.delivery.y_pedido.api.PedidoResponse;
import br.com.restaurante.delivery.z_entrega.domain.Entrega;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/entregas")
public interface EntregaAPI {

    @PostMapping("/{idPedido}/entrega")
    @ResponseStatus(HttpStatus.CREATED)
    EntregaResponse postEntrega(@PathVariable UUID idPedido,
                                @Valid @RequestBody EntregaRequest entregaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EntregaListResponse> getTodasEntregas();

    @GetMapping(value = "/pedido/{idPedido}")
    @ResponseStatus(code = HttpStatus.OK)
    List<EntregaListResponse> getEntregaPorPedido(@PathVariable UUID idPedido);

}
