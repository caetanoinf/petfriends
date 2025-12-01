package br.edu.infnet.petfriends.controller;

import br.edu.infnet.petfriends.domain.Pedido;
import br.edu.infnet.petfriends.service.PedidoQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos/queries")
@RequiredArgsConstructor
@Tag(name = "Pedido Queries", description = "Endpoints para consultas de pedidos")
public class PedidoQueryController {

    private final PedidoQueryService pedidoQueryService;

    @GetMapping
    @Operation(summary = "Listar todos os pedidos", description = "Retorna todos os pedidos cadastrados")
    public ResponseEntity<List<Pedido>> listarTodos() {
        return ResponseEntity.ok(pedidoQueryService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar pedido por ID", description = "Retorna um pedido específico pelo ID")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable String id) {
        return pedidoQueryService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
