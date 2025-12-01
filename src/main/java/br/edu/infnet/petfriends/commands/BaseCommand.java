package br.edu.infnet.petfriends.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {

    @TargetAggregateIdentifier
    public final T id;

    protected BaseCommand(T id) {
        this.id = id;
    }
}
