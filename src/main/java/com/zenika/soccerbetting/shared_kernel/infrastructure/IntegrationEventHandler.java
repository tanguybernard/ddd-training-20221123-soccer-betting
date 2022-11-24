package com.zenika.soccerbetting.shared_kernel.infrastructure;

public interface IntegrationEventHandler<Event extends IntegrationEvent> {

    void handle(Event evt);
}
