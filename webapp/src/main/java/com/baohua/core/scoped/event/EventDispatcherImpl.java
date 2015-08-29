package com.baohua.core.scoped.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author $Id$
 */
public class EventDispatcherImpl implements EventDispatcher {

    private final Map<String, List<EventHandler>> eventHandlers = new HashMap<>();

    public EventDispatcherImpl() {
    }

    @Override
    public void dispatchEvent(Event evt) {

        List<EventHandler> handlers = this.eventHandlers.get(evt.getId());
        if (handlers != null) {
            for (EventHandler handler : handlers) {
                if (handler.handleEvent(evt)) {
                    return;
                }
            }
        }
    }

    @Override
    public void registerEventHandler(String eventId, EventHandler eventHandler) {

        List<EventHandler> handlers = this.eventHandlers.get(eventId);
        if (handlers != null) {
            handlers.add(eventHandler);
        } else {
            handlers = new ArrayList<>();
            handlers.add(eventHandler);
            this.eventHandlers.put(eventId, handlers);
        }
    }

    @Override
    public void unregisterEventHandler(String eventId, EventHandler eventHandler) {

        List<EventHandler> handlers = this.eventHandlers.get(eventId);
        if (handlers != null) {
            handlers.remove(eventHandler);
            if (handlers.isEmpty()) {
                this.eventHandlers.remove(eventId);
            }
        }
    }
}
