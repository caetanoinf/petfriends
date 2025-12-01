package br.edu.infnet.petfriends.events;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PedidoCriadoEvent extends DomainEvent<String> {

    private final String pedidoId;
    private final Long clienteId;
    private final BigDecimal valorTotal;

    public PedidoCriadoEvent(String pedidoId, Long clienteId, BigDecimal valorTotal) {
        super(pedidoId);
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
    }
}
