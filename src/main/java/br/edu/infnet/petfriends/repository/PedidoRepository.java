package br.edu.infnet.petfriends.repository;

import br.edu.infnet.petfriends.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
