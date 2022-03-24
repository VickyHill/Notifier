package com.company.entitynotifier;

import com.company.entity.Entity;
import com.company.entity.EntityType;

import java.util.Optional;

public abstract class BaseEventNotifier<T extends Entity> {

    public abstract boolean shouldHandle(EntityType entityType);

    protected abstract boolean entitySpecificConditionsMet(T entityObj, T originalEntityObj);

    protected abstract Object getNotifyOn(T entityObj);

    public final void handle(T entityObj, T originalEntityObj) {
        Optional<T> notifyOn = getEntityIfConditionsMet(entityObj, originalEntityObj);
        notifyOn.ifPresent(e -> notify(getNotifyOn(e)));
    }

    private Optional<T> getEntityIfConditionsMet(T entityObj, T originalEntityObj) {
        Optional<T> entity;
        if(isPhysicallyDeleted(entityObj)) {
            entity = Optional.of(originalEntityObj);
        } else if(conditionsMet(entityObj, originalEntityObj)) {
            entity = Optional.of(entityObj);
        } else {
            entity = Optional.empty();
        }
        return entity;
    }

    private boolean isPhysicallyDeleted(T entityObj) {
        return entityObj == null;
    }

    private boolean conditionsMet(T entityObj, T originalEntityObj) {
        return originalEntityObj == null
                    || entityObj.getDeleted() != originalEntityObj.getDeleted()
                    || entitySpecificConditionsMet(entityObj, originalEntityObj);
    }

    private void notify(Object notifyOn) {
        System.out.println(notifyOn.toString());
    }

}
