package br.edu.infnet.petfriends.service;

import br.edu.infnet.petfriends.domain.Pedido;
import br.edu.infnet.petfriends.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoQueryService {

    private final PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(String id) {
        return pedidoRepository.findById(id);
    }
}
