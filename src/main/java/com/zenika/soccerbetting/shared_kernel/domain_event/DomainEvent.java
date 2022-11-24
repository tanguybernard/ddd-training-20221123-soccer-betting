package com.zenika.soccerbetting.shared_kernel.domain_event;

import java.util.Date;

public interface DomainEvent{

    Date occurredOn = null;
    String eventName = null;

}
