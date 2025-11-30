package br.edu.infnet.petfriends.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "itens_assinatura")
@Getter
@Setter
@NoArgsConstructor
public class ItemAssinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assinaturaId;
    private Long produtoId;
    private Integer quantidade;
}
