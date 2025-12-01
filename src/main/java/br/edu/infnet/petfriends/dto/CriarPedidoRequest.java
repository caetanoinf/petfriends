package br.edu.infnet.petfriends.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CriarPedidoRequest {
    private Long clienteId;
    private BigDecimal valorTotal;
}
