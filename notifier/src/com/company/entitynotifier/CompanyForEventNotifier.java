package com.company.entitynotifier;

import com.company.entity.CompanyForEvent;
import com.company.entity.Entity;
import com.company.entity.EntityType;

import java.util.Optional;

public class CompanyForEventNotifier extends BaseEventNotifier<CompanyForEvent> {
    @Override
    public boolean shouldHandle(EntityType entityType) {
        return EntityType.CompanyForEvent == entityType;
    }

    @Override
    protected boolean entitySpecificConditionsMet(CompanyForEvent entityObj, CompanyForEvent originalEntityObj) {
        return entityObj.getBlacklisted() != originalEntityObj.getBlacklisted();
    }

    @Override
    protected Object getNotifyOn(CompanyForEvent entityObj) {
        return entityObj.getEvent();
    }


}
