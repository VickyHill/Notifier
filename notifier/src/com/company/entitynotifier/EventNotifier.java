package com.company.entitynotifier;

import com.company.CrawlingStatus;
import com.company.entity.Entity;
import com.company.entity.EntityType;
import com.company.entity.Event;


public class EventNotifier extends BaseEventNotifier<Event> {
    @Override
    public boolean shouldHandle(EntityType entityType) {
        return EntityType.Event == entityType;
    }

    @Override
    protected boolean entitySpecificConditionsMet(Event entityObj, Event originalEntityObj) {
        return CrawlingStatus.TEXT_ANALYZED == entityObj.getCrawlingStatus()
                || CrawlingStatus.TEXT_UPLOADED == entityObj.getCrawlingStatus();
    }

    @Override
    protected Object getNotifyOn(Event entityObj) {
        return entityObj;
    }
}
