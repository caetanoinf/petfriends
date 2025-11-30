package br.edu.infnet.petfriends.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "assinaturas")
@Getter
@Setter
@NoArgsConstructor
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    @Enumerated(EnumType.STRING)
    private StatusAssinatura status;

    @Enumerated(EnumType.STRING)
    private Periodicidade periodicidade;

    private LocalDate proximaEntrega;

    @OneToMany(mappedBy = "assinaturaId", cascade = CascadeType.ALL)
    private List<ItemAssinatura> itens = new ArrayList<>();

    public void adicionarItem(Long produtoId, Integer quantidade) {
        if (produtoId == null) {
            throw new IllegalArgumentException("Produto inválido");
        }
        if (quantidade == null || quantidade < 1) {
            throw new IllegalArgumentException("Quantidade deve ser maior ou igual a 1");
        }
        if (status == StatusAssinatura.CANCELADA) {
            throw new IllegalStateException("Não pode adicionar itens em assinatura cancelada");
        }

        ItemAssinatura item = new ItemAssinatura();
        item.setAssinaturaId(this.id);
        item.setProdutoId(produtoId);
        item.setQuantidade(quantidade);
        this.itens.add(item);
    }

    public void ativar() {
        if (status == StatusAssinatura.ATIVA) {
            throw new IllegalStateException("Assinatura já está ativa");
        }
        if (itens.isEmpty()) {
            throw new IllegalStateException("Assinatura deve ter pelo menos 1 item para ser ativada");
        }
        if (proximaEntrega != null && proximaEntrega.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Data da próxima entrega deve ser futura");
        }
        this.status = StatusAssinatura.ATIVA;
    }

    public void pausar() {
        if (status == StatusAssinatura.CANCELADA) {
            throw new IllegalStateException("Não pode pausar assinatura cancelada");
        }
        this.status = StatusAssinatura.PAUSADA;
    }

    public void cancelar(String motivo) {
        if (status == StatusAssinatura.CANCELADA) {
            throw new IllegalStateException("Assinatura já está cancelada");
        }
        this.status = StatusAssinatura.CANCELADA;
    }
}
