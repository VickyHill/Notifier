package com.company;

import com.company.entity.Entity;
import com.company.entity.EntityType;
import com.company.entitynotifier.BaseEventNotifier;

import java.util.Optional;
import java.util.Set;

public class Notifier implements INotifier {
    private final Set<BaseEventNotifier> eventNotifiers;

    public Notifier(Set<BaseEventNotifier> eventNotifiers) {
        this.eventNotifiers = eventNotifiers;
    }

    @Override
    public void doNotify(Entity entityObj, Entity originalEntityObj, EntityType entityType) {
        Optional<BaseEventNotifier> eventNotifier =
                eventNotifiers.stream().filter(en -> en.shouldHandle(entityType)).findFirst();
        eventNotifier.ifPresent(en -> en.handle(entityObj, originalEntityObj));
    }
}
