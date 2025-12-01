package br.edu.infnet.petfriends.events;

import java.time.Instant;

public class DomainEvent<T> {

    public final T id;
    public final Instant when;

    public DomainEvent(T id) {
        this.id = id;
        this.when = Instant.now();
    }
}
