package br.edu.infnet.petfriends.events;

import lombok.Getter;

@Getter
public class AssinaturaAtivadaEvent extends DomainEvent<Long> {

    private final Long assinaturaId;
    private final Long clienteId;

    public AssinaturaAtivadaEvent(Long assinaturaId, Long clienteId) {
        super(assinaturaId);
        this.assinaturaId = assinaturaId;
        this.clienteId = clienteId;
    }
}
