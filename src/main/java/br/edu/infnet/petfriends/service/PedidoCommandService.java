package br.edu.infnet.petfriends.service;

import br.edu.infnet.petfriends.commands.CriarPedidoCommand;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class PedidoCommandService {

    private final CommandGateway commandGateway;

    public CompletableFuture<String> criarPedido(Long clienteId, BigDecimal valorTotal) {
        String pedidoId = UUID.randomUUID().toString();
        CriarPedidoCommand command = new CriarPedidoCommand(pedidoId, clienteId, valorTotal);
        return commandGateway.send(command);
    }
}
