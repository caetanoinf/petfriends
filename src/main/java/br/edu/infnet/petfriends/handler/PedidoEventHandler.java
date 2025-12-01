package br.edu.infnet.petfriends.handler;

import br.edu.infnet.petfriends.domain.Pedido;
import br.edu.infnet.petfriends.events.PedidoCriadoEvent;
import br.edu.infnet.petfriends.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoEventHandler {

    private final PedidoRepository pedidoRepository;

    @EventHandler
    public void on(PedidoCriadoEvent event) {
        Pedido pedido = new Pedido(
                event.getPedidoId(),
                event.getClienteId(),
                event.getValorTotal()
        );
        pedidoRepository.save(pedido);
    }
}
