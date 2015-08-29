package com.baohua.core.scoped.event;

import com.baohua.core.scoped.event.EventDispatcher;

public interface EventDispatcherAggregate {
    EventDispatcher getEventDispatcher();
}
