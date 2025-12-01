package br.edu.infnet.petfriends.aggregate;

import br.edu.infnet.petfriends.commands.CriarPedidoCommand;
import br.edu.infnet.petfriends.events.PedidoCriadoEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
@NoArgsConstructor
public class PedidoAggregate {

    @AggregateIdentifier
    private String pedidoId;

    private Long clienteId;
    private BigDecimal valorTotal;

    @CommandHandler
    public PedidoAggregate(CriarPedidoCommand command) {
        AggregateLifecycle.apply(new PedidoCriadoEvent(
                command.id,
                command.getClienteId(),
                command.getValorTotal()
        ));
    }

    @EventSourcingHandler
    public void on(PedidoCriadoEvent event) {
        this.pedidoId = event.getPedidoId();
        this.clienteId = event.getClienteId();
        this.valorTotal = event.getValorTotal();
    }
}
