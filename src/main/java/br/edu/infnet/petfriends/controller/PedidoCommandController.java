package br.edu.infnet.petfriends.controller;

import br.edu.infnet.petfriends.dto.CriarPedidoRequest;
import br.edu.infnet.petfriends.service.PedidoCommandService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/pedidos/commands")
@RequiredArgsConstructor
@Tag(name = "Pedido Commands", description = "Endpoints para comandos de pedidos")
public class PedidoCommandController {

    private final PedidoCommandService pedidoCommandService;

    @PostMapping
    @Operation(summary = "Criar novo pedido", description = "Cria um novo pedido utilizando CQRS e Event Sourcing")
    public CompletableFuture<ResponseEntity<String>> criarPedido(@RequestBody CriarPedidoRequest request) {
        return pedidoCommandService.criarPedido(request.getClienteId(), request.getValorTotal())
                .thenApply(pedidoId -> ResponseEntity.ok(pedidoId));
    }
}
