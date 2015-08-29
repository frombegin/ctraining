package com.baohua.core.scoped.event;

public interface EventDispatcher {

    void dispatchEvent(Event evt);

    void registerEventHandler(String eventId, EventHandler eventHandler);

    void unregisterEventHandler(String eventId, EventHandler eventHandler);

}
