package com.zenika.soccerbetting.betting.infrastructure.bus;

import com.zenika.soccerbetting.shared_kernel.infrastructure.EventBus;
import com.zenika.soccerbetting.shared_kernel.infrastructure.IntegrationEvent;

public class RabbitEventBus implements EventBus {

    //inject service RabbitMq

    public void emit(IntegrationEvent event) {
        // rabbitmq send message to channel

    }

}
