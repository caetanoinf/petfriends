package br.edu.infnet.petfriends.eventos;

import lombok.Getter;

import java.time.Instant;

@Getter
public class AssinaturaCanceladaEvent extends DomainEvent<Long> {

    private final Long assinaturaId;
    private final String motivo;

    public AssinaturaCanceladaEvent(Long assinaturaId, String motivo) {
        super(assinaturaId);
        this.assinaturaId = assinaturaId;
        this.motivo = motivo;
    }
}
