package com.zenika.soccerbetting.shared_kernel.infrastructure;

public interface EventBus {

    void emit(IntegrationEvent event);

}
