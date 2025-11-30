package br.edu.infnet.petfriends.eventos;

import lombok.Getter;

import java.time.Instant;

@Getter
public class AssinaturaPausadaEvent extends DomainEvent<Long> {

    private final Long assinaturaId;

    public AssinaturaPausadaEvent(Long assinaturaId) {
        super(assinaturaId);
        this.assinaturaId = assinaturaId;
    }
}
