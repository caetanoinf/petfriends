package br.edu.infnet.petfriends.commands;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CriarPedidoCommand extends BaseCommand<String> {

    private final Long clienteId;
    private final BigDecimal valorTotal;

    public CriarPedidoCommand(String pedidoId, Long clienteId, BigDecimal valorTotal) {
        super(pedidoId);
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }
}
